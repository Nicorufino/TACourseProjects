package com.solvd.newsPortal.connectionPool;

import org.apache.log4j.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Properties;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class ConnectionPool {
    private final static Logger LOGGER = Logger.getLogger(ConnectionPool.class);

    private static ConnectionPool instance;

    private int maxConnections;
    private String url;
    private String dbName;
    private String user;
    private String password;

    private BlockingDeque<Optional<Connection>> connectionStack;

    private ConnectionPool(int maxConnections, String url, String dbName, String user, String password) {
        this.maxConnections = maxConnections;
        this.url = url;
        this.dbName = dbName;
        this.user = user;
        this.password = password;
        this.connectionStack = new LinkedBlockingDeque<>(maxConnections);

        for (int i = 0; i < maxConnections; i++)
            connectionStack.push(Optional.empty());
    }

    public static ConnectionPool getInstance(){
        if (instance == null){
            InputStream input = ConnectionPool.class.getClassLoader().getResourceAsStream("db.properties");
            Properties properties = new Properties();
            try {
                properties.load(input);
            } catch (IOException e) {
                LOGGER.error(e);
            }
            instance = new ConnectionPool(5, properties.getProperty("db.url"), properties.getProperty("db.name"), properties.getProperty("db.user"), properties.getProperty("db.password"));
            LOGGER.debug("connections created");

        }

        return instance;
    }

    public Connection getConnection() {
        if (connectionStack.size() == 0) return null;

        Connection connection = connectionStack.pop().orElse(null);
        if (connection == null)
            try {
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException e){
                LOGGER.error(e);
            }

        return connection;
    }

    public void returnConnection(Connection connection) {
        if (connectionStack.size() < maxConnections) {
            connectionStack.push(Optional.of(connection));
        }
        else {
            throw new RuntimeException("Connection stack reached its max capacity: " + maxConnections);
        }
    }

    public void closeAll(){
        try {
            // Using for each because lambdas cannot throw exceptions
            for (Optional<Connection> connectionBox : connectionStack) {
                Connection connection = connectionBox.orElse(null);
                if (connection != null) connection.close();
            }
        } catch (SQLException e){
            LOGGER.error(e);
        }
    }

    public int getMaxConnections() {
        return maxConnections;
    }
}

package com.solvd.socialNetwork;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Properties;
import java.util.Stack;
import java.util.concurrent.BlockingDeque;

public class ConnectionPool {
    private final static Logger LOGGER = Logger.getLogger(ConnectionPool.class);
    private static ConnectionPool instance;
    private int maxConnection;
    private String url;
    private String dbName;
    private String user;
    private String password;
    private BlockingDeque<Optional<Connection>> connectionStack;

    private ConnectionPool(int maxConnection, String url, String dbName, String user, String password) {
        this.maxConnection = maxConnection;
        this.url = url;
        this.dbName = dbName;
        this.user = user;
        this.password = password;

        for (int i = 0; i < maxConnection; i++)
            connectionStack.push(Optional.empty());
    }

    public static ConnectionPool getInstance() {
        if (instance == null) {
            InputStream input = ConnectionPool.class.getClassLoader().getResourceAsStream("db.properties");
            Properties properties = new Properties();
            try {
                properties.load(input);
            } catch (IOException e) {
                LOGGER.error(e);
            }
            instance = new ConnectionPool(Integer.parseInt(properties.getProperty("ConnectionPool.maxConnections")), properties.getProperty("ConnectionPool.url"), properties.getProperty("ConnectionPool.dbName"), properties.getProperty("ConnectionPool.user"), properties.getProperty("ConnectionPool.password"));
            LOGGER.debug("connections created");

        }

        return instance;
    }

    public Connection getConnection() throws SQLException {
        if (connectionStack.size() == 0) return null;

        Connection connection = connectionStack.pop().orElse(null);
        if (connection == null) {
            connection = DriverManager.getConnection("jdbc:mysql://" + url + "/" + dbName, user, password);
        }

        return connection;

    }

    public void returnConnection(Connection connection) {
        if (connectionStack.size() < maxConnection) {
            connectionStack.push(Optional.of(connection));

        }
    }


    public void close(){
        try {
            for (Optional<Connection> connectionBox : connectionStack) {
                Connection connection = connectionBox.orElse(null);
                if (connection != null) {
                    connection.close();
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        }

    }
}


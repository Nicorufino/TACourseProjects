package com.solvd.newsPortal.connectionPool;

import org.apache.log4j.Logger;
import org.eclipse.persistence.exceptions.ConcurrencyException;

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

    private BlockingDeque<Connection> connectionStack;

    private ConnectionPool(int maxConnections, String url, String dbName, String user, String password) {
        this.maxConnections = maxConnections;
        this.url = url;
        this.dbName = dbName;
        this.user = user;
        this.password = password;
        this.connectionStack = new LinkedBlockingDeque<>(maxConnections);

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
        while (this.connectionStack.isEmpty()) {
            if (connectionStack.size() < maxConnections){
             Connection connection = null;
                try {
                    connection = DriverManager.getConnection(url, user, password);
                    connectionStack.push(connection);

                } catch (SQLException e) {
                    LOGGER.error(e);
                }

                connectionStack.push(connection);
                return connection;

            }

            try {
                wait();
                LOGGER.debug("waiting for connection");
            } catch (InterruptedException exception) {
                LOGGER.error(exception);
            }
        }
        Connection connection = connectionStack.pop();

        return connection;
    }

    public void returnConnection(Connection connection) {
        if (connectionStack.size() < maxConnections) {
            connectionStack.push((connection));
        }
        else {
            throw new RuntimeException("Connection stack reached its max capacity: " + maxConnections);
        }
    }


    public int getMaxConnections() {
        return maxConnections;
    }
}

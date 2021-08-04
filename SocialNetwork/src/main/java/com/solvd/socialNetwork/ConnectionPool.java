package com.solvd.socialNetwork;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Stack;

public class ConnectionPool {
    private int maxConnection;
    private Stack<Connection> connections;
    private final String dbCredentials = "credentials";

    public ConnectionPool() {
    }

    public ConnectionPool(int maxConnection) {
        this.maxConnection = maxConnection;
        this.connections = new Stack<Connection>();
        connections.setSize(maxConnection);
    }

    public Connection getConnection() throws SQLException {
        if (connections.size() == 0) return null;

        Connection connection = connections.pop();

        if (connection == null){
            connection = DriverManager.getConnection(dbCredentials);
        }

        return connection;

    }

    public synchronized void returnConnection(Connection connection) {
        if (connections.size() < maxConnection) {
            connections.push(connection);
        }
        else {
            throw new RuntimeException("Connection stack reached its max capacity: " + maxConnection);
        }
}
    public void close() throws SQLException{
        for (Connection connection: connections){
            if (connection != null) connection.close();
        }
    }
}

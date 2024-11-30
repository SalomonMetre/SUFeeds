package com.kisiwani.sufeeds;

import java.sql.*;

public class DbConnector implements DatabaseCRUD {
    private Connection connection;
    private Statement statement;

    // Constructor to initialize the connection
    public DbConnector(String username, String password, String dbName) {
        try {
            String url = "jdbc:mysql://localhost:3306/" + dbName;
            connection = DriverManager.getConnection(url, username, password);
            
            // Create statement with scrollable and sensitive result set
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            System.out.println("Connected to the database successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to connect to the database.");
        }
    }

    @Override
    public void create(String table, String columns, String values) {
        String sql = "INSERT INTO " + table + " (" + columns + ") VALUES (" + values + ")";
        try {
            int rowsInserted = statement.executeUpdate(sql);
            System.out.println(rowsInserted + " row(s) inserted.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ResultSet read(String table, String condition) {
        String sql = "SELECT * FROM " + table + (condition.isEmpty() ? "" : " WHERE " + condition);
        try {
            return statement.executeQuery(sql);  // Now returns a scrollable and sensitive ResultSet
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public ResultSet read(String table, String columns, String condition) {
        String sql = "SELECT " + columns +" FROM " + table + (condition.isEmpty() ? "" : " WHERE " + condition);
        try {
            return statement.executeQuery(sql);  // Now returns a scrollable and sensitive ResultSet
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(String table, String updates, String condition) {
        String sql = "UPDATE " + table + " SET " + updates + (condition.isEmpty() ? "" : " WHERE " + condition);
        try {
            int rowsUpdated = statement.executeUpdate(sql);
            System.out.println(rowsUpdated + " row(s) updated.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String table, String condition) {
        String sql = "DELETE FROM " + table + (condition.isEmpty() ? "" : " WHERE " + condition);
        try {
            int rowsDeleted = statement.executeUpdate(sql);
            System.out.println(rowsDeleted + " row(s) deleted.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void closeConnection() {
        try {
            if (statement != null) statement.close();
            if (connection != null) connection.close();
            System.out.println("Database connection closed.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

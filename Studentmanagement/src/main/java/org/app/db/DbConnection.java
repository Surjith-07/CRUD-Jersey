package org.app.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static final String url = "jdbc:mysql://localhost:3306/*****";
    private static final String userName = "root";
    private static final String password = "*****";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, userName, password);
    }
}

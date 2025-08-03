package com.company.bankingapplication.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection getConnection() {
        String url = "jdbc:postgresql://localhost:5432/bankingapp";
        String user = "postgres";
        String password = "aaditya"; 

        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Database connection failed!");
            e.printStackTrace();
            return null; 
        }
    }
}

package com.company.bankingapplication.dao;

import com.company.bankingapplication.db.DBConnection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchCostumerDb {
    public static void search(String accountNum) {
        String sql="SELECT * FROM customers WHERE account_number = ?";
        try(Connection c = DBConnection.getConnection()) {
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, accountNum);
            ResultSet rs = p.executeQuery();
            if(rs.next()){

                System.out.println(
                                "FirstName: " + rs.getString("first_name") + "\n" +
                                "LastName: " + rs.getString("last_name") + "\n" +
                                "Username: " + rs.getString("username") + "\n" +
                                "AccountNumber: " + rs.getString("account_number") + "\n" +
                                "Balance: " + rs.getDouble("balance") + "\n" +
                                "Active: " + rs.getBoolean("is_active")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

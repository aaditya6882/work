package com.company.bankingapplication.dao;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.company.bankingapplication.Model.TransactionHistoryModel;
import com.company.bankingapplication.Model.TransactionModel;
import com.company.bankingapplication.db.DBConnection;

public class TransactionDb {
        public TransactionModel  readCustomerFile(String accNumber) {
            String sql = "SELECT account_number, balance FROM customers WHERE account_number = ?";
        try(Connection c = DBConnection.getConnection())  {
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, accNumber);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                String accountNumber = rs.getString("account_number");
                double balance = rs.getDouble("balance");
                return new TransactionModel(accountNumber, balance);
            }
        } catch (SQLException  e) {
            e.printStackTrace();
        }
        return null;
    }
     public void writeToFile(TransactionModel m) {
                String sql = "UPDATE customers SET balance = ? WHERE account_number = ?";
        try (Connection c = DBConnection.getConnection()) {
            PreparedStatement p = c.prepareStatement(sql);
            p.setDouble(1, m.getBalance());
            p.setString(2, m.getAccountNumber());
            p.executeUpdate();
        } catch (SQLException  e) {
            e.printStackTrace();
    }
}
public void writeToTransactionFile(String uNam, String accNum, double amount, String type) {
        try (Connection c = DBConnection.getConnection();
             PreparedStatement p = c.prepareStatement("INSERT INTO transactions (username, account_number, amount, type, date) VALUES (?, ?, ?, ?, ?)")) {
            p.setString(1, uNam);
            p.setString(2, accNum);
            p.setDouble(3, amount);
            p.setString(4, type);
            p.setTimestamp(5, new java.sql.Timestamp(System.currentTimeMillis()));
            p.executeUpdate();
        } catch (SQLException  e) {
            e.printStackTrace();
}
    }
     public List<TransactionHistoryModel> readTransactionHistory(String uNam,String accNumber) {
        List<TransactionHistoryModel> history = new ArrayList<>();
        String sql = "SELECT account_number, amount, type, date FROM transactions WHERE account_number = ? AND username = ?";
        try (Connection c = DBConnection.getConnection()){
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, accNumber);
            p.setString(2, uNam);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                String accountNumber = rs.getString("account_number");
                double amount = rs.getDouble("amount");
                String type = rs.getString("type");
                Date date = rs.getTimestamp("date");
                history.add(new TransactionHistoryModel(accountNumber, amount, type, date.toString(),uNam));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return history;
    }
}
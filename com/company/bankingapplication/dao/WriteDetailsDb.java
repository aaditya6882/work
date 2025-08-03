package com.company.bankingapplication.dao;
import com.company.bankingapplication.db.DBConnection;
import com.company.bankingapplication.Model.CreateAccount;
import java.sql.*;

public class WriteDetailsDb {
    public WriteDetailsDb(CreateAccount a) {
        String sql = "INSERT INTO customers(first_name,last_name,username,password,account_number,balance) VALUES(?,?,?,?,?,?)";
        try (Connection c = DBConnection.getConnection();
             PreparedStatement p = c.prepareStatement(sql)) {
            p.setString(1, a.getFirstName());
            p.setString(2, a.getLastName());
            p.setString(3, a.getUsername());
            p.setString(4, a.getPassword());
            p.setString(5, a.getAccountNum());
            p.setDouble(6, a.getBalance());
            p.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
}

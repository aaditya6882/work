package com.company.bankingapplication.dao;

import com.company.bankingapplication.db.DBConnection;
import java.sql.*;
import java.sql.Connection;

public class ReadCustomerDb {
    public boolean validateUser(String uName, String password) {
        String sql = "select * from customers where username=? and password=?";
        try (Connection c = DBConnection.getConnection()) {
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, uName);
            p.setString(2, password);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean usernameExists(String uName) {
        String sql = "select * from customers where username=?";
        try (Connection c = DBConnection.getConnection()) {
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, uName);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean accountNumberExists(String accountNum) {
        String sql = "select * from customers where account_number=?";
        try(Connection c=DBConnection.getConnection()){
            PreparedStatement p=c.prepareStatement(sql);
            p.setString(1, accountNum);
            ResultSet rs=p.executeQuery();
            if (rs.next()) {
                return true;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    public boolean isUserOwnerOfAccount(String uName, String accountNum) {
        String sql = "select * from customers where username=? and account_number=?";
        try(Connection c=DBConnection.getConnection()){
            PreparedStatement p=c.prepareStatement(sql);
            p.setString(1, uName);
            p.setString(2, accountNum);
            ResultSet rs=p.executeQuery();
            if (rs.next()) {
                return true;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}

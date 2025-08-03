package com.company.bankingapplication.dao;

import com.company.bankingapplication.db.DBConnection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckBalanceDb {
    public double  readAll(String uNam)
    {
        String sql="SELECT balance FROM customers WHERE username=?";
        try(Connection c= DBConnection.getConnection()){
            PreparedStatement ps=c.prepareStatement(sql);
            ps.setString(1,uNam);
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                double balance=rs.getDouble("balance");
                return balance;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return 0.0;
    }
}

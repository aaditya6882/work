package com.company.bankingapplication.dao;

import com.company.bankingapplication.Model.DisableAccountModel;
import com.company.bankingapplication.Model.EnableAccountModel;
import com.company.bankingapplication.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EnableAccountDb {
    public void enable(EnableAccountModel m){
        String sql="UPDATE customers SET is_active = true WHERE account_number = ?";
        try(Connection c= DBConnection.getConnection()){
            PreparedStatement p=c.prepareStatement(sql);
            p.setString(1,m.getAccountNum());
            p.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

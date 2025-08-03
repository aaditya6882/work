package com.company.bankingapplication.dao;

import com.company.bankingapplication.Model.DisableAccountModel;
import com.company.bankingapplication.db.DBConnection;

import java.sql.*;


public class DisableAccountDb {
public void disable(DisableAccountModel m){
    String sql="UPDATE customers SET is_active = false WHERE account_number = ?";
    try(Connection c= DBConnection.getConnection()){
        PreparedStatement p=c.prepareStatement(sql);
        p.setString(1,m.getAccountNum());
        p.execute();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
}

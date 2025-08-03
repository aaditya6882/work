package com.company.bankingapplication.dao;

import com.company.bankingapplication.Model.ModifyAccountModel;
import com.company.bankingapplication.db.DBConnection;

import java.sql.*;

public class ModifyAccountDb {
    public void modifyAccount(ModifyAccountModel m) {
        String sql = "UPDATE customers SET first_name = ?, last_name = ?, username = ?, password = ? WHERE account_number = ?";
        try(Connection c = DBConnection.getConnection()){
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, m.getFirstName());
            p.setString(2, m.getLastName());
            p.setString(3, m.getUsername());
            p.setString(4, m.getPassword());
            p.setString(5,m.getAccountNum());
            int r=p.executeUpdate();
            if(r>0){
                System.out.println("Account updated successfully!");
            }else {
                System.out.println("Account update failed!");
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

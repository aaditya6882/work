package com.company.bankingapplication.ServiceLayer;

import com.company.bankingapplication.Model.CreateAccount;
import com.company.bankingapplication.dao.ReadCustomerDb;
import com.company.bankingapplication.dao.WriteDetailsDb;

public class WriteDetailsService {
    public WriteDetailsService(CreateAccount c) {
        ReadCustomerDb readDb = new ReadCustomerDb();

        if (readDb.usernameExists(c.getUsername())) {
            System.out.println("Error: Username already exists. Choose another username.");
        }
        else if (readDb.accountNumberExists(c.getAccountNum())) {
            System.out.println("Error: Account number already exists.");
        }
        else {
            WriteDetailsDb writeDb = new WriteDetailsDb(c);
            System.out.println("Account created successfully!");
        }

    }
}

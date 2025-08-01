package com.company.bankingapplication.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCostumer {

    public boolean validateUser(String uName, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader("com/company/bankingapplication/costumer.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {continue;}
                String[] details = line.split(",");
                if (details.length > 2) {                
                    if (details[2].equals(uName) && details[3].equals(password)) {
                    return true;
                }
            } 

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean usernameExists(String uName) {
        try (BufferedReader reader = new BufferedReader(new FileReader("com/company/bankingapplication/costumer.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {continue;}
                String[] details = line.split(",");
                if (details.length > 2 && details[2].equals(uName)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean accountNumberExists(String accountNum) {
        try (BufferedReader reader = new BufferedReader(new FileReader("com/company/bankingapplication/costumer.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {continue;}
                String[] details = line.split(",");
                // accountNum is column 5
                if (details.length > 2 && details[4].equals(accountNum)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean isUserOwnerOfAccount(String uName, String accountNum) {
    try (BufferedReader reader = new BufferedReader(new FileReader("com/company/bankingapplication/costumer.csv"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.trim().isEmpty()) continue;
            String[] details = line.split(",");
            if (details.length > 4 && details[2].equals(uName) && details[4].equals(accountNum)) {
                return true;
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return false;
}
}

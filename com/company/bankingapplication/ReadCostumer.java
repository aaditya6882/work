package com.company.bankingapplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCostumer {

    public boolean validateUser(String uName, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader("com/company/bankingapplication/costumer.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] details = line.split(",");
                if (details[2].equals(uName) && details[3].equals(password)) {
                    return true;
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
                String[] details = line.split(",");
                // username is column 3
                if (details[2].equals(uName)) {
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
                String[] details = line.split(",");
                // accountNum is column 5
                if (details[4].equals(accountNum)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}

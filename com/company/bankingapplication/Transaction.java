package com.company.bankingapplication;

import java.io.*;
import java.util.*;

public class Transaction {
private double balance;
private String accNum;
boolean found=false;
    public void readCustomerFile(String accNumber) {
        try  {
            BufferedReader reader = new BufferedReader(new FileReader("com/company/bankingapplication/costumer.csv"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] details = line.split(",");
                if (details.length == 7 && (details[4].equals(accNumber))) {
                    this.balance = Double.parseDouble(details[5]);
                    this.accNum=details[4];
                    this.found = true;
                    break;
                }

  
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void deposit(double amount) {
        if (found) {
            this.balance += amount;
                System.out.println("Deposit successful. New balance: " + this.balance);
                writeToFile(accNum);
        } else {
            System.out.println("Account not found.");
        }

    }

    public void withdraw(double amount) {
        if (found) {
            if (this.balance < amount) {
                System.out.println("Insufficient balance");
            } else {
                this.balance -= amount;
                System.out.println("Withdrawal successful. New balance: " + this.balance);
                writeToFile(accNum);
            }
        }else {
            System.out.println("Account not found.");
        }

    }
    public void writeToFile(String accNumber) {
                ArrayList<String> customerDetails = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("com/company/bankingapplication/costumer.csv"));
            String line;
              while ((line = reader.readLine()) != null) {
                String[] details = line.split(",");
                if (details.length == 7 && (details[4].equals(accNumber))) {
                    details[5] = String.valueOf(this.balance);
                    line = String.join(",", details);
                }
                customerDetails.add(line);
            }
                } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("com/company/bankingapplication/costumer.csv"));
            for (String customerLine : customerDetails) {
                writer.write(customerLine);
                writer.newLine();
            }
            writer.close();
        } catch (Exception e) {
        }

    }
}
package com.company.bankingapplication;

import java.io.*;


public class Transaction {
private double balance;
private String accNum;
    public void readCustomerFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("com/company/bankingapplication/costumer.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] details = line.split(",");
                this.balance = Double.parseDouble(details[5]);
                this.accNum=details[4];
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void deposit(String accNum, double amount) {
        if (accNum.equals(this.accNum)) {
            this.balance += amount;
        }
    }

    public void withdraw(String accNum, double amount) {
        if (accNum.equals(this.accNum)) {
            if (this.balance < amount) {
                System.out.println("Insufficient balance");
            } else {
                this.balance -= amount;
            }
        }
    }
}

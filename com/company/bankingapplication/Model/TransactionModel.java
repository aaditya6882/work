package com.company.bankingapplication.Model;

public class TransactionModel {
    private String accountNumber;
    private double balance;
    public TransactionModel(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

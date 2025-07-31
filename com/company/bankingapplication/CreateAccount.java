package com.company.bankingapplication;

public class CreateAccount {
    private String FirstName;
    private String LastName;
    private String username;
    private String password;
    private String accountNum;
    private double balance;
    public CreateAccount(String FirstName, String LastName, String username, String password, String accountNum, double balance) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.username = username;
        this.password = password;
        this.accountNum = accountNum;
        this.balance = balance;
    }
    public String getFirstName() {
        return FirstName;
    }
    public String getLastName() {
        return LastName;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getAccountNum() {
        return accountNum;
    }
    public double getBalance() {
        return balance;
    }
}

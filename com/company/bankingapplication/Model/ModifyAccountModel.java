package com.company.bankingapplication.Model;

public class ModifyAccountModel {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String accountNum;

    public ModifyAccountModel(String firstName, String lastName, String username, String password, String accountNum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.accountNum = accountNum;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getAccountNum() { return accountNum; }
}

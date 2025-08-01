package com.company.bankingapplication;
import java.io.*;
public class WriteDetails extends CreateAccount {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String accountNum;

    public WriteDetails(String firstName, String lastName, String username, String password, String accountNum, double balance) {
        super(firstName, lastName, username, password, accountNum, balance);
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.accountNum = accountNum;
        try {
            FileWriter writer = new FileWriter("com/company/bankingapplication/costumer.csv", true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            String csv = String.format("%s,%s,%s,%s,%s,%.2f,%b",
                firstName, lastName, username, password, accountNum, balance,true);
            bufferedWriter.write(csv);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
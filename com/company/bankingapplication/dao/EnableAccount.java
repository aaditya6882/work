package com.company.bankingapplication.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class EnableAccount {
    private String accountNum;

    public EnableAccount(String accountNum) {
        this.accountNum = accountNum;
    }
    public void enable(){
        ArrayList<String> customerDetails = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("com/company/bankingapplication/costumer.csv"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] details = line.split(",");
                if (details.length == 7 && (details[4].equals(accountNum))) {
                    details[6] = "true"; 
                    line = String.join(",", details);
                }
                customerDetails.add(line);
            }
        } catch (Exception e) {
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
            e.printStackTrace();
        }
    }
}

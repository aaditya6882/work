package com.company.bankingapplication.file;
import java.io.*;
import java.util.*;
public class DisableAccount {
    private String accountNum;

    public DisableAccount(String accountNum) {
        this.accountNum = accountNum;
    }
    public void disable(){
        ArrayList<String> customerDetails = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("com/company/bankingapplication/costumer.csv"));
            String line;
            while ((line = reader.readLine()) != null) {
                 if (line.trim().isEmpty()) continue;
                String[] details = line.split(",");
                if (details.length == 7 && (details[4].equals(accountNum))) {
                    details[6] = "false"; 
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

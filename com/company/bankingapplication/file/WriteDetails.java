package com.company.bankingapplication.file;
import com.company.bankingapplication.Model.CreateAccount;
import java.io.*;
public class WriteDetails{
    public WriteDetails(CreateAccount c) {
        try {
            FileWriter writer = new FileWriter("com/company/bankingapplication/costumer.csv", true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            String csv = String.format("%s,%s,%s,%s,%s,%.2f,%b",
                c.getFirstName(),c.getLastName(), c.getUsername(), c.getPassword(), c.getAccountNum(), c.getBalance(),true);
            bufferedWriter.write(csv);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
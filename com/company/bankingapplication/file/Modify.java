package com.company.bankingapplication.file;
import java.io.*;
import java.util.*;
public class Modify {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    public Modify(String firstName, String lastName, String username, String password, String accountNum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        modifyAccount(accountNum);
    }
    public void modifyAccount(String accountNum) {
        ArrayList<String> customerDetails = new ArrayList<>();
        try {
            BufferedReader reader= new BufferedReader(new FileReader("com/company/bankingapplication/costumer.csv"));
            String line ;
            while((line=reader.readLine())!=null){
                String[] details = line.split(",");
                if(details.length==7 && (details[4].equals(accountNum))){
                    details[0] = this.firstName;
                    details[1] = this.lastName;
                    details[2] = this.username;
                    details[3] = this.password;
                }
                customerDetails.add(String.join(",", details));
            }
}catch (IOException e) {
            e.printStackTrace();
}
        try {
            FileWriter writer = new FileWriter("com/company/bankingapplication/costumer.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (String customerLine : customerDetails) {
                bufferedWriter.write(customerLine);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
package com.company.bankingapplication;
import java.io.*;
public class CheckBalance {
    public double  readAll(String uNam)
{
    try {
        BufferedReader r=new BufferedReader(new FileReader("com/company/bankingapplication/costumer.csv"));
        String line;
        while ((line=r.readLine())!=null) {
            String[] parts=line.split(",");
            if(uNam.equals(parts[2])){
                double balance = Double.parseDouble(parts[5]);
                return balance;
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return 0.0;
}}

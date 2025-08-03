package com.company.bankingapplication.file;

import com.company.bankingapplication.Model.TransactionHistoryModel;
import com.company.bankingapplication.Model.TransactionModel;
import java.io.*;
import java.util.*;

public class Transaction {
    public TransactionModel  readCustomerFile(String accNumber) {
        try  {
            BufferedReader reader = new BufferedReader(new FileReader("com/company/bankingapplication/costumer.csv"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] details = line.split(",");
                if (details.length == 7 && (details[4].equals(accNumber))) {
                    double balance = Double.parseDouble(details[5]);
                    return new TransactionModel(details[4], balance);
                }

  
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void writeToFile(TransactionModel m) {
                ArrayList<String> customerDetails = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("com/company/bankingapplication/costumer.csv"));
            String line;
              while ((line = reader.readLine()) != null) {
                String[] details = line.split(",");
                if (details.length == 7 && (details[4].equals(m.getAccountNumber()))) {
                    details[5] = String.valueOf(m.getBalance());
                    line = String.join(",", details);
                }
                customerDetails.add(line);
            }
                } catch (IOException e) {
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
        }

    }
    public void writeToTransactionFile(String uNam, String accNum, double amount, String type) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("com/company/bankingapplication/transactions.csv", true))) {
            String transactionLine = uNam+","+accNum + "," + amount + "," + type + "," + new Date();
            writer.write(transactionLine);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
}
    }
    public List<TransactionHistoryModel> readTransactionHistory(String uNam,String accNumber) {
        List<TransactionHistoryModel> history = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(
                new FileReader("com/company/bankingapplication/transactions.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] details = line.split(",");
                if (details.length == 5 && details[1].equals(accNumber) && details[0].equals(uNam)) {
                    history.add(new TransactionHistoryModel(
                            details[1],
                            Double.parseDouble(details[2]),
                            details[3],
                            details[4],details[0]
                    ));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return history;
    }
}
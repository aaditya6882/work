package com.company.bankingapplication.ServiceLayer;
import com.company.bankingapplication.Model.TransactionHistoryModel;
import com.company.bankingapplication.Model.TransactionModel;
import com.company.bankingapplication.file.Transaction;
import com.company.bankingapplication.dao.TransactionDb;
import java.util.*;
public class TransactionService {
    private double balance;
        public void deposit(double amount, String accNum, String uNam) {
            // Transaction t= new Transaction();
            TransactionDb t= new TransactionDb();
            TransactionModel m = t.readCustomerFile(accNum);
        if (m!=null) {
            double currentBalance = m.getBalance();
            this.balance = currentBalance + amount;
            m.setBalance(this.balance);
            System.out.println("Deposit successful. New balance: " + this.balance);
            t.writeToFile(m);
            t.writeToTransactionFile(uNam, accNum, amount, "Deposit");
        } else {
            System.out.println("Account not found.");
        }

    }

    public void withdraw(double amount, String accNum, String uNam) {
        //  Transaction t= new Transaction();
            TransactionDb t= new TransactionDb();
         TransactionModel m = t.readCustomerFile(accNum);
        if (m!=null) {
            double currentBalance = m.getBalance();
            if (currentBalance < amount) {
                System.out.println("Insufficient balance");
            } else {
                this.balance = currentBalance - amount;
                m.setBalance(this.balance);
                System.out.println("Withdrawal successful. New balance: " + this.balance);
                t.writeToFile(m);
                t.writeToTransactionFile(uNam, accNum, amount, "Withdrawal");
            }
        }else {
            System.out.println("Account not found.");
        }

    }
public void showTransactionHistory(String uNam,String accNum) {
        // Transaction d = new Transaction();
            TransactionDb d= new TransactionDb();
        List<TransactionHistoryModel> history = d.readTransactionHistory(uNam,accNum);

        if (history.isEmpty()) {
            System.out.println("No transactions found for account: " + accNum);
        } else {
            System.out.println("Transaction History for account: " + accNum);
            for (TransactionHistoryModel t : history) {
                System.out.println(
                    t.getTimestamp() + " - " + t.getType() + " - " + t.getAmount()
                );
            }
        }
    }
}

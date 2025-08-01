package com.company.bankingapplication.Model;

public class TransactionHistoryModel {
    private String uNam;
    private String accNum;
    private double amount;
    private String type;
    private String timestamp;

    public TransactionHistoryModel(String accNum, double amount, String type, String timestamp, String uNam) {
        this.accNum = accNum;
        this.amount = amount;
        this.type = type;
        this.timestamp = timestamp;
        this.uNam = uNam; 
    }
    public String getUNam() { return uNam; }
    public String getAccNum() { return accNum; }
    public double getAmount() { return amount; }
    public String getType() { return type; }
    public String getTimestamp() { return timestamp; }
}

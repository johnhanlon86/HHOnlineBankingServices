package com.mycompany.onlinebankingservices.model;

import java.util.Date;

public class Transaction {

    private String transactionId;
    private Date transactionDate;
    private String description;
    private String type;
    private double preTransactionBalance;
    private double postTransactionBalance;

    // Should we have a 'transactionAmount' instance variable? 
    public Transaction(String description, String type, double transactionAmount) {
        this.description = description;
        this.type = type;
    }

    public Transaction deposit(double depositAmount) {

        Transaction transaction = null;

        // LOGIC here
        return transaction;
    }

    public Transaction withdraw(double withdrawAmount) {

        Transaction transaction = null;

        // LOGIC here
        return transaction;

    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPreTransactionBalance() {
        return preTransactionBalance;
    }

    public void setPreTransactionBalance(double preTransactionBalance) {
        this.preTransactionBalance = preTransactionBalance;
    }

    public double getPostTransactionBalance() {
        return postTransactionBalance;
    }

    public void setPostTransactionBalance(double postTransactionBalance) {
        this.postTransactionBalance = postTransactionBalance;
    }

}

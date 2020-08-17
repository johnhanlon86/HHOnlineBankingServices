package com.mycompany.onlinebankingservices.model;

import java.util.Date;
import java.util.UUID;

public class Transaction {

    private UUID transactionId;
    private double transactionAmount;
    private Date transactionDate;
    private String description;
    private String accountType;
    private double preTransactionBalance;
    private double postTransactionBalance;
    private String status;
    private String transactionType;

    public Transaction() {
    }

    public Transaction(String accountType, double preTransactionBalance) {
        transactionId = UUID.randomUUID();
        this.accountType = accountType;
        this.preTransactionBalance = preTransactionBalance;
        transactionDate = new Date();
    }

    public Transaction(String accountType, double preTransactionBalance, String description) {
        transactionId = UUID.randomUUID();
        this.accountType = accountType;
        this.preTransactionBalance = preTransactionBalance;
        this.description = description;
        transactionDate = new Date();
    }

    public double deposit(double depositAmount) {
        transactionAmount = depositAmount;
        postTransactionBalance = preTransactionBalance + depositAmount;
        status = "Successful";
        transactionType = "Deposit";
        return postTransactionBalance;
    }

    public double withdraw(double withdrawAmount) {

        transactionType = "Withdraw";

        if (accountType.equalsIgnoreCase("debit")) {

            // Do not let balance go minus
            if (preTransactionBalance >= withdrawAmount) {
                transactionAmount = withdrawAmount;
                postTransactionBalance = preTransactionBalance - withdrawAmount;
                status = "Successful";

                return postTransactionBalance;
            } else {
                postTransactionBalance = preTransactionBalance;
                status = "Failed";
                return preTransactionBalance;
            }
        } else if (accountType.equalsIgnoreCase("credit")) {
            transactionAmount = withdrawAmount;
            postTransactionBalance = preTransactionBalance - withdrawAmount;
            status = "Successful";
            return postTransactionBalance;
        } else {
            postTransactionBalance = preTransactionBalance;
            status = "Failed";
            return preTransactionBalance;
        }

    }

    public String getTransactionId() {
        return transactionId.toString();
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
        return accountType;
    }

    public void setType(String type) {
        this.accountType = type;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    @Override
    public String toString() {

        String transactionDetails = "TransactionId: " + transactionId + "\nTransaction Amount: "
                + transactionAmount + "\nTransaction Date: " + transactionDate + "\nDescription: "
                + description + "\nAccount Type: " + accountType + "\nPre-Transaction Balance: "
                + preTransactionBalance + "\nPost-Transaction Balance: " + postTransactionBalance
                + "\nStatus: " + status + "\nTransactionType: " + transactionType;

        return transactionDetails;
    }

}

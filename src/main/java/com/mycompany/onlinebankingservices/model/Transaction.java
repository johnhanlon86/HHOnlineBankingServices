package com.mycompany.onlinebankingservices.model;

import java.util.Date;
import java.util.UUID;

public class Transaction {

    // ** Change transationId to type UUID **
    private UUID transactionId;
    private double transactionAmount;
    private Date transactionDate;
    private String description;
    /*
    I have changed 'accountType' back to String ->
    Transaction t1 = new Transaction("Debit", 100);
    is clearer than ->
    Transaction t1 = new Transaction(true, 100);
     */
    private String accountType;
    private double preTransactionBalance;
    private double postTransactionBalance;
    
    //** ADD to ERD - Status added **
    private String status;
    // We could add a success or failed status - on a debit account
    // a transaction will not go through if there is not enough money in the account.
    // This could be hard to spot withit a status warning. 
    
    // We could add a 'transactionType' - it will allow customers to easily see
    // what transactions are deposits vs withdraws
    
    public Transaction(){
    }
    
    // ** Added'preTransactionBalance' to the constructors **
    // ** Removed transactionAmount **
    public Transaction(String accountType, double preTransactionBalance) {
        transactionId = UUID.randomUUID();
        this.accountType = accountType;
        this.preTransactionBalance = preTransactionBalance;
        transactionDate = new Date();
    }

    // ** Added'preTransactionBalance' to the constructors **
    // ** Removed transactionAmount **
    public Transaction(String accountType, double preTransactionBalance, String description) {
        transactionId = UUID.randomUUID();
        this.accountType = accountType;
        this.preTransactionBalance = preTransactionBalance;
        this.description = description;
        transactionDate = new Date();
    }

    // ** Changed return accountType to double: postTransactionBalance **
    public double deposit(double depositAmount) {
        transactionAmount = depositAmount;
        postTransactionBalance = preTransactionBalance + depositAmount;
        status = "Successful";
        return postTransactionBalance;
    }

    // ** Changed return accountType to double: postTransactionBalance **
    public double withdraw(double withdrawAmount) {

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

    @Override
    public String toString() {

        String transactionDetails = "TransactionId: " + transactionId + "\nTransaction Amount: "
                + transactionAmount + "\nTransaction Date: " + transactionDate + "\nDescription: "
                + description + "\nAccount Type: " + accountType + "\nPre-Transaction Balance: "
                + preTransactionBalance + "\nPost-Transaction Balance: " + postTransactionBalance 
                + "\nStatus: " + status;

        return transactionDetails;
    }

}

package com.mycompany.onlinebankingservices.model;

import java.util.Date;

public class Transaction {

    private String transactionId;
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

    // ** Added'preTransactionBalance' to the constructors **
    // ** Removed transactionAmount **
    public Transaction(String accountType, double preTransactionBalance) {
        this.accountType = accountType;
        this.preTransactionBalance = preTransactionBalance;
        transactionDate = new Date();
    }

    // ** Added'preTransactionBalance' to the constructors **
    // ** Removed transactionAmount **
    public Transaction(String accountType, double preTransactionBalance, String description) {
        this.accountType = accountType;
        this.preTransactionBalance = preTransactionBalance;
        this.description = description;
        transactionDate = new Date();
    }

    // ** Changed return accountType to double: postTransactionBalance **
    public double deposit(double depositAmount) {

        postTransactionBalance = preTransactionBalance + depositAmount;
        return postTransactionBalance;
    }

    // ** Changed return accountType to double: postTransactionBalance **
    public double withdraw(double withdrawAmount) {

        if (accountType.equalsIgnoreCase("debit")) {

            // Do not let balance go minus
            if (preTransactionBalance >= withdrawAmount) {
                postTransactionBalance = preTransactionBalance - withdrawAmount;
            }
        }

        if (accountType.equalsIgnoreCase("credit")) {
            postTransactionBalance = preTransactionBalance - withdrawAmount;
        }

        return postTransactionBalance;
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

    @Override
    public String toString() {

        String transactionDetails = "TransactionId: " + transactionId + "Transaction Amount: "
                + transactionAmount + "Transaction Date: " + transactionDate + "Description: "
                + description + "Account Type: " + accountType + "Pre-Transaction Balance: " + preTransactionBalance + "Post-Transaction Balance: " + postTransactionBalance;

        return transactionDetails;
    }

}

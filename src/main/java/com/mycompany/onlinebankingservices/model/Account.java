package com.mycompany.onlinebankingservices.model;

import java.util.ArrayList;

public class Account {

    private int accountNumber;
    private double balance;
    private String accountType;
    private String sortCode;
    private ArrayList<Transaction> transactionList;

    public Account(int accountNumber, double openingBalance, String accountType, String sortCode) {
        this.accountNumber = accountNumber;
        this.balance = openingBalance;
        this.accountType = accountType;
        this.sortCode = sortCode;
    }

    public Transaction makeTransaction(String transactionType, double transactionAmount, String description) {

        Transaction transaction = null;

        // LOGIC here
        return transaction;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isBalanceZero() {
        boolean isZero = false;
        if (getBalance() == 0) {
            isZero = true;
        }
        return isZero;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getSortCode() {
        return sortCode;
    }

    public void setSortCode(String sortCode) {
        this.sortCode = sortCode;
    }

    public ArrayList<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(ArrayList<Transaction> transactionList) {
        this.transactionList = transactionList;
    }
}

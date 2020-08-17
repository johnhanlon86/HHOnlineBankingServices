package com.mycompany.onlinebankingservices.model;

import java.util.ArrayList;

public class Account {

    private int accountNumber;
    private double balance;
    private String accountType;
    private String sortCode;
    private String accountName = "General";
    private ArrayList<Transaction> transactionList = new ArrayList<>();

    public Account() {
    }

    public Account(int accountNumber, double openingBalance, String accountType, String sortCode, String accountName) {
        this.accountNumber = accountNumber;
        this.balance = openingBalance;
        this.accountType = accountType;
        this.sortCode = sortCode;
        this.accountName = accountName;
    }

    public Account(int accountNumber, double openingBalance, String accountType, String sortCode) {
        this.accountNumber = accountNumber;
        this.balance = openingBalance;
        this.accountType = accountType;
        this.sortCode = sortCode;
    }

    public Transaction deposit(double depositAmount, String description) {

        Transaction transaction = new Transaction(accountType, balance, description);
        balance = transaction.deposit(depositAmount);
        transactionList.add(transaction);
        return transaction;
    }

    public Transaction withdraw(double withdrawAmount, String description) {

        Transaction transaction = new Transaction(accountType, balance, description);
        balance = transaction.withdraw(withdrawAmount);
        transactionList.add(transaction);
        return transaction;
    }

    public boolean isBalanceZero() {
        boolean isZero = false;
        if (balance == 0) {
            isZero = true;
        }
        return isZero;
    }

    public Transaction getTransactionByIndex(int index) {

        Transaction transaction = null;

        if (!transactionList.isEmpty()) {
            if (index <= transactionList.size()) {
                transaction = transactionList.get(index);
            }
        }
        return transactionList.get(index);
    }

    public Transaction getTransactionById(String transactionId) {

        Transaction transaction = null;

        for (int i = 0; i < transactionList.size(); i++) {
            if (transactionList.get(i).getTransactionId().equals(transactionId)) {
                transaction = transactionList.get(i);
            }
        }
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

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @Override
    public String toString() {
        String accountDetails
                = "\nAccount Number: " + accountNumber + "\nBalance: "
                + balance + "\nAccountType: " + accountType + "\nSortCode: "
                + sortCode + "\nAccountName: " + accountName;

        return accountDetails;
    }
}

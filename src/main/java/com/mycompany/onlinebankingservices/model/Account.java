package com.mycompany.onlinebankingservices.model;

import java.util.ArrayList;

public class Account {

    // No need to have a customerId in the account class.
    // private int customerID;
    //private String transactionType;
    //private double transactionAmount;
    //private String description;
    //private int senderAccountNumber;
    //private int receiverAccountNumber;
    
    // Perhaps we should assign accountNumbers automatically? Reduces chance of
    // duplicate account numbers between customers.
    private int accountNumber;
    private double balance;
    private String accountType;
    private String sortCode;
    private ArrayList<Transaction> transactionList = new ArrayList<>();

    // No need to have a customerId in the account class ->
    // The customer will have an account. The account has an accountNumber.
    // The customer has a customerID. 
    public Account(int accountNumber, double openingBalance, String accountType, String sortCode) {
        // this.customerID = customerID;
        this.accountNumber = accountNumber;
        this.balance = openingBalance;
        this.accountType = accountType;
        this.sortCode = sortCode;
    }

    // No need to pass a transaction object into ().
    // Create within the method instead.
    public Transaction makeTransaction(String transactionType, double transactionAmount, String description) {

        // These belong to the 'Transaction' class and are there already as instance
        // variables.
        //this.transactionType = transactionType;
        //this.transactionAmount = transactionAmount;
        //this.description = description;
        Transaction transaction = null;

        if (transactionType.equalsIgnoreCase("Deposit")) {
            transaction = new Transaction(accountType, balance, description);
            balance = transaction.deposit(transactionAmount);
            transactionList.add(transaction);
        }

        if (transactionType.equalsIgnoreCase("Withdraw")) {
            transaction = new Transaction(accountType, balance, description);
            balance = transaction.withdraw(transactionAmount);
            transactionList.add(transaction);
        }

        return transaction;
    }

    /*
    // This functionality was added into the 'BankService' class instead when
    // we talked on Friday. Apologies (must have forgotten to remove from this
    // class)! 
       
    public Transaction makeTransfer(String transactionType, double transactionAmount, String description, int senderAccountNumber, int receiverAccountNumber) {
        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;
        this.description = description;
        this.senderAccountNumber = senderAccountNumber;
        this.receiverAccountNumber = receiverAccountNumber;

        Transaction transaction = null;

        //transactionList.add(transaction);
        // Transaction transaction = null;
        // LOGIC here
        return transaction;
    }
     */
    // ** New method - Add to ERD diagram. ** 
    public boolean isBalanceZero() {
        boolean isZero = false;
        if (balance == 0) {
            isZero = true;
        }
        return isZero;
    }
    
    // ** NEW METHOD - Add to ERD ** 
    public Transaction getTransactionByIndex(int index) {

        Transaction transaction = null;

        if (!transactionList.isEmpty()) {
            if (index <= transactionList.size()) {
                transaction = transactionList.get(index);
            }
        }
        return transactionList.get(index);
    }

    // ** NEW METHOD - Add to ERD ** 
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

    @Override
    public String toString() {
        String accountDetails
                = "Account Number: " + accountNumber + "\nBalance: "
                + balance + "\n AccountType: " + accountType + "\nSortCode: "
                + sortCode;

        return accountDetails;
    }
}

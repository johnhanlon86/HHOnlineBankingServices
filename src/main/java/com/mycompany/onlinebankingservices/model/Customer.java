package com.mycompany.onlinebankingservices.model;

import java.util.ArrayList;
// import java.lang.Math;

public class Customer {

    // Changed to static and int.
    // We could implement UUID numbers instead, see transactionID in transaction
    // class. 
    private static double customerID;

    // By chance of randomness customers could have the same 'customerId'?
    //private double randomNumber;
    private String firstName;
    private String secondName;
    private String emailAddress;
    private String password;
    private String locationAddress;

    // These are instance variables of the 'Account class'. 
    // private String accountType;
    // private int accountNumber;
    // private double openingBalance;
    // private String sortCode;
    // private boolean isBalanceZero;
    private ArrayList<Account> accountsList;

    public Customer(String firstName, String secondName, String emailAddress, String password) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.emailAddress = emailAddress;
        this.password = password;
        this.customerID = customerID++;
    }

    public Customer(String firstName, String secondName, String emailAddress, String password, String locationAddress) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.emailAddress = emailAddress;
        this.password = password;
        this.locationAddress = locationAddress;
        this.customerID = customerID++;

        // By chance of randomness customers could have the same 'customerId'?
        //this.customerID = generateNewCustomerID();
    }

    /*
    // Updated to private method.
    // By chance of randomness customers could have the same 'customerId'?
    private double generateNewCustomerID() {
        for (int i = 1; i <= 2; i++) {
            double randomNumber = Math.random();
        }
        return randomNumber;
    }
     */
    // 
    public void openAccount(String accountType, int accountNumber, double openingBalance, String sortCode) {

        Account account = new Account(accountNumber, openingBalance, accountType, sortCode);
        accountsList.add(account);
    }

    public void clostAccount(int accountNumber) {

        for (int i = 0; i < accountsList.size(); i++) {
            if (accountsList.get(i).getAccountNumber() == accountNumber) {

                if (accountsList.get(i).isBalanceZero()) {
                    accountsList.remove(i);
                } else {
                    System.out.println("Account balance must be zero in order to close account. Please arrange for funds to be withdrawn or transferred.");
                }
            }
        }
    }

    // No need to pass in an account. Can create account within the method.
    // Pass in the variables/data needed to create/open the account instead. 
    /*
    public void openAccount(int customerID, Account account) {
        accountsList.add(account);       
        System.out.println("You have created a new account - CustomerID: " + customerID);
    }
     */
 /*
    // ADD TO METHOD IN ERD: Parameter ArrayList<Account> accountsList.
    public void closeAccount(int accountNumber, ArrayList<Account> accountsList) {
        this.accountsList = accountsList;
        this.accountNumber = accountNumber;
        int index = 0;

        // Use method loop to access elements and check for account number.
        for (int i = 0; i < accountsList.size(); i ++) {
            if (accountsList.contains(accountNumber)){
                index = accountsList.indexOf(accountNumber);
            }
        }
        
        if (accountsList.get(index).isBalanceZero()) {
            accountsList.remove(accountNumber);
        } else { 
            System.out.println("Account balance must be zero in order to close account. Please arrange for funds to be withdrawn or transferred.");
        }
    }
     */
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLocationAddress() {
        return locationAddress;
    }

    public void setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress;
    }

    public ArrayList<Account> getAccountsList() {
        return accountsList;
    }

    public void setAccountsList(ArrayList<Account> accountsList) {
        this.accountsList = accountsList;
    }

}

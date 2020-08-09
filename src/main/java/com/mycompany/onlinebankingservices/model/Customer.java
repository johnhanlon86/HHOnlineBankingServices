package com.mycompany.onlinebankingservices.model;

import java.util.ArrayList;
import java.util.Iterator;

public class Customer {

    private String firstName;
    private String secondName;
    private String emailAddress;
    private String password;
    private String locationAddress;
    private String accountType;
    private int accountNumber;
    private double openingBalance;
    private String sortCode;
    private boolean isBalanceZero;
    private ArrayList<Account> accountsList;

    public Customer(String firstName, String secondName, String emailAddress, String password) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.emailAddress = emailAddress;
        this.password = password;
    }

    public Customer(String firstName, String secondName, String emailAddress, String password, String locationAddress) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.emailAddress = emailAddress;
        this.password = password;
        this.locationAddress = locationAddress;
    }

    public void openAccount(String accountType, int accountNumber, double openingBalance, String sortCode) {
        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.openingBalance = 0;
        this.sortCode = sortCode;
    }

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

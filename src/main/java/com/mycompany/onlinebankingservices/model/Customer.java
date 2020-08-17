package com.mycompany.onlinebankingservices.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Customer {

    private static int customerIDStatic;
    private int customerID;
    private String firstName;
    private String secondName;
    private String emailAddress;
    private String password;
    private String locationAddress;

    private ArrayList<Account> accountsList = new ArrayList<>();

    public Customer() {
    }

    public Customer(String firstName, String secondName, String emailAddress, String password) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.emailAddress = emailAddress;
        this.password = password;
        this.customerID = customerIDStatic++;
    }

    public Customer(String firstName, String secondName, String emailAddress, String password, String locationAddress) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.emailAddress = emailAddress;
        this.password = password;
        this.locationAddress = locationAddress;
        this.customerID = customerIDStatic++;

    }

    public void openAccount(String accountType, int accountNumber, double openingBalance, String sortCode) {

        Account account = new Account(accountNumber, openingBalance, accountType, sortCode);
        accountsList.add(account);
    }

    public void openAccount(String accountType, int accountNumber, double openingBalance, String sortCode, String accountName) {

        Account account = new Account(accountNumber, openingBalance, accountType, sortCode, accountName);
        accountsList.add(account);
    }

    public void closeAccount(int accountNumber) {

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

    // ** NEW METHOD - Add to ERD **
    public Account getAccountByAccountNumber(int accountNumber) {
        Account account = null;

        for (int i = 0; i < accountsList.size(); i++) {

            if (accountsList.get(i).getAccountNumber() == accountNumber) {
                account = accountsList.get(i);
            }
        }
        return account;
    }

    public List<Account> getAllCustomerAccounts() {
        List<Account> accountList = new ArrayList<>();

        for (int i = 0; i < accountsList.size(); i++) {
            accountList.add(accountsList.get(i));
        }

        return accountList;
    }

    public int getCustomerID() {
        return customerID;
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

    @Override
    public String toString() {
        String customerDetails = "CustomerID: " + customerID + "FirstName: " + firstName + "\nSecondName: " + secondName + "\nEmailAddress: " + emailAddress + "\nPassword: " + password;
        return customerDetails;
    }

}

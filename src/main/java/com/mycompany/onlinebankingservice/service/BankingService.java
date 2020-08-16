package com.mycompany.onlinebankingservice.service;

import com.mycompany.onlinebankingservices.model.Account;
import com.mycompany.onlinebankingservices.model.Customer;
import com.mycompany.onlinebankingservices.model.Transaction;
import java.util.ArrayList;
import java.util.List;
import org.jvnet.hk2.annotations.Service;

@Service
public class BankingService {

    public static List<Customer> bankService = new ArrayList<>();
    
    String firstName;
    String secondName;
    String emailAddress;
    String customerPassword;
    String locationAddress;
    int customerID;
    String newFirstName;
    String newSecondName;

    public List<Customer> createPastCustomers() {

        Customer customer01 = new Customer("Daryl", "Howe", "testemail@hotmail.com", "darylhowe");
        customer01.openAccount("Debit", 83232, 1000, "HH1234");
        customer01.openAccount("Credit", 41324, 0, "HH1234");
        customer01.getAccountByAccountNumber(83232).deposit(100, "Savings");
        customer01.getAccountByAccountNumber(83232).deposit(200, "Birthday Money");
        customer01.getAccountByAccountNumber(83232).deposit(1500, "Wages");
        customer01.getAccountByAccountNumber(83232).withdraw(500, "Groceries");
        customer01.getAccountByAccountNumber(41324).withdraw(2500, "Holiday Security Deposit");
        customer01.getAccountByAccountNumber(41324).deposit(500, "Holiday Payement");
        customer01.getAccountByAccountNumber(41324).deposit(500, "Holiday Payement");

        Customer customer02 = new Customer("Alex", "Jackson", "mj@gmail.com", "alexjackson");
        customer02.openAccount("Credit", 99943, 50_000, "HH1234");
        customer02.getAccountByAccountNumber(99943).withdraw(150_000, "House Decor");
        customer02.getAccountByAccountNumber(99943).deposit(300_000, "Wages");

        Customer customer03 = new Customer("Ciara", "Black", "ciarablack@hotmail.com", "ciarablack");
        customer03.openAccount("Debit", 58392, 2500, "HH9102");
        customer03.getAccountByAccountNumber(58392).deposit(125, "Saving");
        customer03.getAccountByAccountNumber(58392).withdraw(55, "Drinks");

        bankService.add(customer01);
        bankService.add(customer02);
        bankService.add(customer03);

        return bankService;
    }

    // Create New Customer (Including Location).
    public List<Customer> createNewCustomer(String firstName, String secondName, String emailAddress, String customerPassword, String locationAddress) {
        
        this.firstName = firstName;
        this.secondName = secondName;
        this.emailAddress = emailAddress;
        this.customerPassword = customerPassword;
        this.locationAddress = locationAddress;

        Customer newCustomer = new Customer(firstName, secondName, emailAddress, customerPassword, locationAddress);

        bankService.add(newCustomer);

        return bankService;
    }
    
    // Create New Customer (Without Location).
    public List<Customer> createNewCustomer(String firstName, String secondName, String emailAddress, String customerPassword) {
        
        this.firstName = firstName;
        this.secondName = secondName;
        this.emailAddress = emailAddress;
        this.customerPassword = customerPassword;

        Customer newCustomer = new Customer(firstName, secondName, emailAddress, customerPassword);

        bankService.add(newCustomer);

        return bankService;
    }    
    
    // Update Customer Details.
    public List<Customer> updateCustomerDetails(int customerID, String newFirstName, String newSecondName, String emailAddress, String customerPassword) {
        
        this.customerID = customerID;
        this.newFirstName = newFirstName;
        this.newSecondName = newSecondName;
        this.emailAddress = emailAddress;
        this.customerPassword = customerPassword;
        Customer updatedCustomer = new Customer(newFirstName, newSecondName, emailAddress, customerPassword);

        for (int i = 0; i < bankService.size(); i++) {
            if (bankService.get(i).getCustomerID() == customerID && bankService.get(i).getPassword().equals(customerPassword)) {
                bankService.add(i, updatedCustomer);
                break;
            }
        }

        return bankService;
    }    
    
    
    // Update Customer Email.
    
    
    
    // Update Customer Location Address.
    
    
    
    // Open Customer Account.
    
    
    
    // Close Customer Account.
    
    
    
    // Get Customer Details.
    
    
    
    // Get Customer Accounts.
    
    
    
    
    // ******** SECURITY *******
    /**
     * A method to check a customers security details.
     *
     * @param customerId The customers Id number
     * @param customerPassword The customers password which they must enter.
     * @return The matched customer if success, null if failed.
     */
    private Customer checkSecurityDetials(int customerId, String customerPassword) {
        Customer theCustomer = null;

        System.out.println("Checking security details.. .. ");

        for (int i = 0; i < bankService.size(); i++) {
            if (bankService.get(i).getCustomerID() == customerId && bankService.get(i).getPassword().equals(customerPassword)) {
                theCustomer = bankService.get(i);
                break;
            }
        }

        if (theCustomer != null) {
            System.out.println("Security check succesful.");
        } else {
            System.out.println("Customer with customerId: " + customerId + " and password: " + customerPassword + " not found.");
        }
        return theCustomer;
    }
    
    
    

    // ******** ACCOUNT *******
    public Account getAccountDetails(int customerId, int accountNumber, String customerPassword) {

        Account account = null;

        Customer theCustomer = checkSecurityDetials(customerId, customerPassword);

        if (theCustomer != null) {
            account = getAccountHelper(theCustomer, accountNumber);
        }
        return account;
    }

    // THIS RETURNS 0 EVEN IF PASSWORD IS INCORRECT?
    public double getAccountBalance(int customerId, int accountNumber, String customerPassword) {

        double balance = 0;

        Customer theCustomer = checkSecurityDetials(customerId, customerPassword);
        if (theCustomer != null) {
            Account account = getAccountHelper(theCustomer, accountNumber);
            balance = account.getBalance();
        }
        return balance;
    }

    public String getAccountSortCode(int customerId, int accountNumber, String customerPassword) {

        String sortCode = "Unavailable";

        Customer theCustomer = checkSecurityDetials(customerId, customerPassword);
        if (theCustomer != null) {
            Account account = getAccountHelper(theCustomer, accountNumber);
            sortCode = account.getSortCode();
        }
        return sortCode;
    }

    public String getAccountType(int customerId, int accountNumber, String customerPassword) {

        String accountType = "Unavailable";

        Customer theCustomer = checkSecurityDetials(customerId, customerPassword);
        if (theCustomer != null) {

            Account account = getAccountHelper(theCustomer, accountNumber);
            accountType = account.getAccountType();
        }
        return accountType;
    }

    public Transaction deposit(int customerId, int accountNumber, String customerPassword, double depositAmount, String description) {

        Transaction transaction = null;

        Customer theCustomer = checkSecurityDetials(customerId, customerPassword);
        if (theCustomer != null) {

            Account account = getAccountHelper(theCustomer, accountNumber);
            transaction = account.deposit(depositAmount, description);
        }
        return transaction;
    }

    public Transaction withdraw(int customerId, int accountNumber, String customerPassword, double withdrawAmount, String description) {

        Transaction transaction = null;

        Customer theCustomer = checkSecurityDetials(customerId, customerPassword);
        if (theCustomer != null) {

            Account account = getAccountHelper(theCustomer, accountNumber);
            transaction = account.withdraw(withdrawAmount, description);
        }
        return transaction;
    }
    
    public List<Transaction> transfer(int accountNumberSender, int accountNumberReciever, double transferAmount, int customerIdSender, int customerIdReciever, String customerPasswordSender, String description) {

        Customer theSenderCustomer = checkSecurityDetials(customerIdSender, customerPasswordSender);
        Account senderAccount = getAccountHelper(theSenderCustomer, accountNumberSender);
        Transaction transaction = null;
        Transaction transaction02 = null;
        
        for (int i = 0; i < bankService.size(); i++) {

            // If there is a customer with the matched 'customerIdReciever'..
            if (bankService.get(i).getCustomerID() == customerIdReciever) {
                transaction = senderAccount.withdraw(transferAmount, description);
                
                // Need to implement a way to check if it is a debit account only
                // if the withdraw transaction was successful allow the deposit
                // to be made. Could implement a success/failure instance variable
                // within every transaciton (see message within transaction class).
               transaction02 = bankService.get(i).getAccountByAccountNumber(accountNumberReciever).deposit(transferAmount, description);
            }
        }
        
        List<Transaction> transactionList = new ArrayList<>();
        transactionList.add(transaction);
        transactionList.add(transaction02);
        
        return transactionList;
    }

    public List<Transaction> getAccountHistory(int customerId, int accountNumber, String customerPassword) {

        List<Transaction> accountHistory = null;
        Customer theCustomer = checkSecurityDetials(customerId, customerPassword);

        if (theCustomer != null) {

            Account account = getAccountHelper(theCustomer, accountNumber);
            accountHistory = account.getTransactionList();
        }
        return accountHistory;
    }

   // ******** TRANSACTION *******

    
    public Transaction getTransactionById(int customerId, int accountNumber, String customerPassword, String transactionId) {

        Transaction transaction = null;
        Customer theCustomer = checkSecurityDetials(customerId, customerPassword);

        if (theCustomer != null) {

            Account account = getAccountHelper(theCustomer, accountNumber);

            for (int j = 0; j < account.getTransactionList().size(); j++) {

                if (account.getTransactionList().get(j).getTransactionId().equals(transactionId)) {

                    transaction = account.getTransactionList().get(j);
                }
            }
        }
        return transaction;
    }

    private Account getAccountHelper(Customer theCustomer, int accountNumber) {

        Account theAccount = null;

        for (int i = 0; i < theCustomer.getAccountsList().size(); i++) {

            if (theCustomer.getAccountsList().get(i).getAccountNumber() == accountNumber) {
                theAccount = theCustomer.getAccountsList().get(i);
            }
        }
        return theAccount;
    }

}

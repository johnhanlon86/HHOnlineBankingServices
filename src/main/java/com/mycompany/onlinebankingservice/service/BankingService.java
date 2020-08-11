package com.mycompany.onlinebankingservice.service;

import com.mycompany.onlinebankingservices.model.Account;
import com.mycompany.onlinebankingservices.model.Customer;
import java.util.ArrayList;
import java.util.List;
import org.jvnet.hk2.annotations.Service;

@Service
public class BankingService {

    public static List<Customer> bankService = new ArrayList<>();

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
            for (int i = 0; i < theCustomer.getAccountsList().size(); i++) {

                if (theCustomer.getAccountsList().get(i).getAccountNumber() == accountNumber) {
                    account = theCustomer.getAccountsList().get(i);
                }
            }
        }
        return account;
    }
    

    
    
   


}

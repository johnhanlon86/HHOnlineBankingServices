package com.mycompany.onlinebankingservice.service;

import com.mycompany.onlinebankingservices.model.Customer;
import java.util.ArrayList;
import java.util.List;

public class BankingService {

    public static List<Customer> bankService = new ArrayList<>();

    public List<Customer> createPastCustomers() {

        Customer customer01 = new Customer("Daryl", "Howe", "testemail@hotmail.com", "darylhowe");
        customer01.openAccount("Debit", 83232, 1000, "HH1234");
        customer01.openAccount("Credit", 41324, 0, "HH1234");
        customer01.getAccountByAccountNumber(83232).makeTransaction("Deposit", 100, "Savings");
        customer01.getAccountByAccountNumber(83232).makeTransaction("Deposit", 200, "Birthday Money");
        customer01.getAccountByAccountNumber(83232).makeTransaction("Deposit", 1500, "Wages");
        customer01.getAccountByAccountNumber(83232).makeTransaction("Withdraw", 500, "Groceries");
        customer01.getAccountByAccountNumber(41324).makeTransaction("Withdraw", 2500, "Holiday Security Deposit");
        customer01.getAccountByAccountNumber(41324).makeTransaction("Deposit", 500, "Holiday Payement");
        customer01.getAccountByAccountNumber(41324).makeTransaction("Deposit", 500, "Holiday Payement");

        Customer customer02 = new Customer("Alex", "Jackson", "mj@gmail.com", "alexjackson");
        customer02.openAccount("Credit", 99943, 50_000, "HH1234");
        customer02.getAccountByAccountNumber(99943).makeTransaction("Withdraw", 150_000, "House Decor");
        customer02.getAccountByAccountNumber(99943).makeTransaction("Deposit", 300_000, "Wages");

        Customer customer03 = new Customer("Ciara", "Black", "ciarablack@hotmail.com", "ciarablack");
        customer03.openAccount("Debit", 58392, 2500, "HH9102");
        customer03.getAccountByAccountNumber(58392).makeTransaction("Deposit", 125, "Saving");
        customer03.getAccountByAccountNumber(58392).makeTransaction("Withdraw", 55, "Drinks");

        bankService.add(customer01);
        bankService.add(customer02);
        bankService.add(customer03);
        
        return bankService;
    }
}

package com.mycompany.onlinebankingservice.tests;

import com.mycompany.onlinebankingservices.model.Customer;

public class CustomerTests {

    public static void main(String args[]) {

        System.out.println("******* Customer Tests ********");

        System.out.println("");
        System.out.println("#Test01#");
        System.out.println("Creating customer.. FirstName: Daryl, SecondName: Howe, Email: testemail@hotmail.com, Password: testpassword");
        Customer customer01 = new Customer("Daryl", "Howe", "testemail@hotmail.com", "testpassword");
        System.out.println("");
        System.out.println("*Display customer details*");
        System.out.println(customer01);

        System.out.println("Open account with following details..");
        System.out.println("Account Number: 8888, Balance: 0, AccountType: Debit, SortCode: HH1234");
        System.out.println("");
        System.out.println("*Display Account Details*: ");
        customer01.openAccount("debit", 8888, 0, "HH1234");
        System.out.println(customer01.getAccountByAccountNumber(8888));

        System.out.println("");
        System.out.println("*Display Non Exisiting Account*: ");
        System.out.println(customer01.getAccountByAccountNumber(9999));
       
        System.out.println("");
        System.out.println("Open account with following details..");
        System.out.println("Account Number: 3333, Balance: 1000, AccountType: Credit, SortCode: HH1234");
        customer01.openAccount("Credit", 3333, 10000, "HH1234");

        System.out.println("");
        System.out.println("*Display All Customer Accounts*: ");
        System.out.println(customer01.getAccountsList());

    }
}

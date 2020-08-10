package com.mycompany.onlinebankingservice.tests;

import com.mycompany.onlinebankingservices.model.Account;

public class AccountTests {
    public static void main(String args[]){
    
        
        System.out.println("******* Account Tests ********");

        System.out.println("");
        System.out.println("#Test01#");
        System.out.println("Creating Account.. \nAccountType: Debit, AccountNumber: 111, OpeningBalance: 0, SortCode: HH1234");
        Account account01 = new Account(111, 0, "Debit", "HH1234");
        System.out.println("Depositing: 200, Description: 'Savings'");
        account01.makeTransaction("Deposit", 200, "Savings");
        
        System.out.println("");
        System.out.println("*Display Account Details*: ");
        System.out.println(account01);
        
        System.out.println("");
        System.out.println("*Display Transaction Details*: ");
        System.out.println(account01.getTransactionByIndex(0));
        
        System.out.println("");
        System.out.println("Withdrawing 100..");
        account01.makeTransaction("Withdraw", 100, "Electricity bill");
        System.out.println("*Display Account Details*: ");
        System.out.println(account01);
        
        System.out.println("");
        System.out.println("*Display Transaction Details*: ");
        System.out.println(account01.getTransactionByIndex(1));
        
        System.out.println("");
        System.out.println("Withdrawing 500..");
        System.out.println("Note: Is DEBIT account and should NOT got MINUS.");
        account01.makeTransaction("Withdraw", 500, "Shopping");
        System.out.println("*Display Account Details*: ");
        System.out.println(account01);
        
        System.out.println("");
        System.out.println("*Display Transaction Details*: ");
        System.out.println(account01.getTransactionByIndex(2));
        
        System.out.println("");
        System.out.println("#Test02#");
        System.out.println("Creating Account.. \nAccountType: Debit, AccountNumber: 111, OpeningBalance: 0, SortCode: HH1234");
        Account account02 = new Account(111, 0, "Debit", "HH1234");
        System.out.println("Withdrawing: 200, Description: 'Takeway'");
        account02.makeTransaction("Withdraw", 200, "Takeway");
        System.out.println("Expected balance: 0");
        System.out.println("Acutal balance: " + account02.getBalance());
        System.out.println("*Display Transaction Details*: ");
        System.out.println(account02.getTransactionByIndex(0));
        
        System.out.println("");
        System.out.println("#Test03#");
        System.out.println("Creating Account.. \nAccountType: Credit, AccountNumber: 111, OpeningBalance: 500, SortCode: HH1234");
        Account account03 = new Account(111, 500, "Credit", "HH1234");
        System.out.println("*Display Account Details*: ");
        System.out.println(account03);
        
        System.out.println("");
        System.out.println("Withdrawing: 1000, Description: 'Home Decor'");
        account03.makeTransaction("Withdraw", 1000, "Home Decor");
        System.out.println("Expected balance: -500");
        System.out.println("Acutal balance: " + account03.getBalance());
       
        System.out.println("");
        System.out.println("*Display Account Details*: ");
        System.out.println(account03);

        System.out.println("");
        System.out.println("*Display Transaction Details*: ");
        System.out.println(account03.getTransactionByIndex(0));
        

    }
}

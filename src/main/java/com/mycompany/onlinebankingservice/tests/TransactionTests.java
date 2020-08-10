package com.mycompany.onlinebankingservice.tests;

import com.mycompany.onlinebankingservices.model.Transaction;

public class TransactionTests {

    public static void main(String args[]) {

        System.out.println("******* Transaction Tests ********");

        System.out.println("");
        System.out.println("#Test01#");
        System.out.println("Creating debit account with 1000 euro..");
        Transaction transaction01 = new Transaction("Debit", 1000);

        System.out.println("Depositing 500 euro..");
        transaction01.deposit(500);
       
        System.out.println("Expected 'Post-Transaction Balance': 1500.0 ");
        System.out.println("Actual: " + transaction01.getPostTransactionBalance());

        
        System.out.println("");
        System.out.println("#Test02#");
        System.out.println("Creating credit account with 1000 euro..");
        Transaction transaction02 = new Transaction("Credit", 1000);

        System.out.println("Depositing 500 euro..");
        transaction02.deposit(500);

        System.out.println("Expected 'Post-Transaction Balance': 1500.0 ");
        System.out.println("Actual: " + transaction02.getPostTransactionBalance());

        
        
        System.out.println("");
        System.out.println("#Test03#");
        System.out.println("Creating credit account with 1000 euro..");
        Transaction transaction03 = new Transaction("Credit", 1000);

        System.out.println("Withdraw 500 euro..");
        transaction03.withdraw(500);

        System.out.println("Expected 'Post-Transaction Balance': 500.0 ");
        System.out.println("Actual: " + transaction03.getPostTransactionBalance());

        
        
        System.out.println("");
        System.out.println("#Test04#");
        System.out.println("Creating credit account with 1000 euro..");
        Transaction transaction04 = new Transaction("Credit", 1000);

        System.out.println("Withdraw 2000 euro..");
        transaction04.withdraw(2000);

        System.out.println("Expected 'Post-Transaction Balance': -1000.0 ");
        System.out.println("Actual: " + transaction04.getPostTransactionBalance());

                
        System.out.println("");
        System.out.println("#Test05#");
        System.out.println("Creating debit account with 1000 euro..");
        Transaction transaction05 = new Transaction("Debit", 1000);

        System.out.println("Withdraw 2000 euro..");
        System.out.println("Expected 'Post-Transaction Balance': 1000.0 ");
        System.out.println("Actual: " + transaction05.withdraw(2000));

        
        
        System.out.println("");
        System.out.println("#Test06#");
        System.out.println("Creating debit account with 1000 euro..");
        Transaction transaction06 = new Transaction("Debit", 1000);

        System.out.println("Withdraw 500 euro..");
        transaction06.withdraw(500);

        System.out.println("Expected 'Post-Transaction Balance': 500.0 ");
        System.out.println("Actual: " + transaction06.getPostTransactionBalance());

    }
}

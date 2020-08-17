package com.mycompany.onlinebankingservices.resources;

import com.google.gson.Gson;
import com.mycompany.onlinebankingservice.service.BankingService;
import com.mycompany.onlinebankingservices.model.Account;
import com.mycompany.onlinebankingservices.model.Customer;
import com.mycompany.onlinebankingservices.model.Transaction;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/bank")
public class BankResource {

    private BankingService bankService = new BankingService();

    // curl -vi -X GET -G "http://localhost:49000/api/bank/test"
    @GET
    @Path("/test")
    public String test() {
        return "Hello world";
    }

    // NOTE: This should be called only once every time application is restarted.
    // curl -vi -X GET -G "http://localhost:49000/api/bank/createpastcustomers"

    @GET
    @Path("/createpastcustomers")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPastCustomers() {

        Gson gson = new Gson();
        List<Customer> customersList = bankService.createPastCustomers();
        return Response.status(Response.Status.CREATED).entity(gson.toJson(customersList)).build();
    }

    // curl -vi -X GET -G "http://localhost:49000/api/bank"    
    // This returns the entire list of customer - used for testing. 
    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createBankService() {

        Gson gson = new Gson();
        List<Customer> customersList = bankService.getBankingService();
        return Response.status(Response.Status.CREATED).entity(gson.toJson(customersList)).build();
    }
    
    
    
    // ******** CUSTOMER *******
    
    // Create new customer (JSON).
    // curl -vi -X GET -G "http://localhost:49000/api/bank/createnewcustomer/Carl/Rodgers/carl@gmail.com/carlrodgers"
    // curl -vi -X GET -G "http://localhost:49000/api/bank/createnewcustomer/{firstName}/{secondName}/{emailAddress}/{customerPassword}"

    @POST
    @Path("/createnewcustomer/{firstName}/{secondName}/{emailAddress}/{customerPassword}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createNewCustomerJSON(@PathParam("firstName") String firstName, @PathParam("secondName") String secondName, @PathParam("emailAddress") String emailAddress, @PathParam("customerPassword") String customerPassword, String locationAddress) {

        Gson gson = new Gson();
        Customer customer = bankService.createNewCustomer(firstName, secondName, emailAddress, customerPassword, locationAddress);
        return Response.status(Response.Status.CREATED).entity(gson.toJson(customer)).build();
    }

    // Create new customer (XML).
    @POST
    @Path("/createnewcustomer/{firstName}/{secondName}/{emailAddress}/{customerPassword}")
    @Produces(MediaType.APPLICATION_XML)
    public Customer createNewCustomerXML(@PathParam("firstName") String firstName, @PathParam("secondName") String secondName, @PathParam("emailAddress") String emailAddress, @PathParam("customerPassword") String customerPassword, String locationAddress) {

        Customer customer = bankService.createNewCustomer(firstName, secondName, emailAddress, customerPassword, locationAddress);
        return customer;
    }

    
    // Update customer details (JSON).
    // curl -vi -X GET -G "http://localhost:49000/api/bank/updatecustomerdetails/{customerID}/{newFirstName}/{newSecondName}/{newEmailAddress}/{newCustomerPassword}/{oldCustomerPassword}"
    // curl -vi -X GET -G "http://localhost:49000/api/bank/updatecustomerdetails/{customerID}/{newFirstName}/{newSecondName}/{newEmailAddress}/{newCustomerPassword}/{oldCustomerPassword}"
    @PUT
    @Path("/updatecustomerdetails/{customerID}/{newFirstName}/{newSecondName}/{newEmailAddress}/{newCustomerPassword}/{oldCustomerPassword}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateCustomerDetailsJSON(@PathParam("customerID") int customerID, @PathParam("newFirstName") String newFirstName, @PathParam("newSecondName") String newSecondName, @PathParam("newEmailAddress") String newEmailAddress, @PathParam("newCustomerPassword") String newCustomerPassword, @PathParam("oldCustomerPassword") String oldCustomerPassword) {

        Gson gson = new Gson();
        Customer customer = bankService.updateCustomerDetails(customerID, newFirstName, newSecondName, newEmailAddress, newCustomerPassword, oldCustomerPassword);
        return Response.status(Response.Status.CREATED).entity(gson.toJson(customer)).build();
    }

    // Update customer details (XML).
    @PUT
    @Path("/updatecustomerdetails/{customerID}/{newFirstName}/{newSecondName}/{newEmailAddress}/{newCustomerPassword}/{oldCustomerPassword}")
    @Produces(MediaType.APPLICATION_XML)
    public Customer updateCustomerDetailsXML(@PathParam("customerID") int customerID, @PathParam("newFirstName") String newFirstName, @PathParam("newSecondName") String newSecondName, @PathParam("newEmailAddress") String newEmailAddress, @PathParam("newCustomerPassword") String newCustomerPassword, @PathParam("oldCustomerPassword") String oldCustomerPassword) {

        Customer customer = bankService.updateCustomerDetails(customerID, newFirstName, newSecondName, newEmailAddress, newCustomerPassword, oldCustomerPassword);
        return customer;
    }
    
    // curl -vi -X GET -G "http://localhost:49000/api/bank/opencustomeraccount/0/Credit/777745/500/HH1234/darylhowe"
    // curl -vi -X GET -G "http://localhost:49000/api/bank/opencustomeraccount/{customerID}/{accountType}/{accountNumber}/{openingBalance}/{sortCode}/{customerPassword}"
    // Open customer account (JSON).
    @PUT
    @Path("/opencustomeraccount/{customerID}/{accountType}/{accountNumber}/{openingBalance}/{sortCode}/{customerPassword}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response openCustomerAccountJSON(@PathParam("customerID") int customerID, @PathParam("accountType") String accountType, @PathParam("accountNumber") int accountNumber, @PathParam("openingBalance") int openingBalance, @PathParam("sortCode") String sortCode, @PathParam("customerPassword") String customerPassword) {

        Gson gson = new Gson();
        Customer customer = bankService.openCustomerAccount(customerID, accountType, accountNumber, openingBalance, sortCode, customerPassword);
        return Response.status(Response.Status.CREATED).entity(gson.toJson(customer)).build();
    }

    // Open customer account (XML).
    @PUT
    @Path("/opencustomeraccount/{customerID}/{accountType}/{accountNumber}/{openingBalance}/{sortCode}/{customerPassword}")
    @Produces(MediaType.APPLICATION_XML)
    public Customer openCustomerAccountXML(@PathParam("customerID") int customerID, @PathParam("accountType") String accountType, @PathParam("accountNumber") int accountNumber, @PathParam("openingBalance") int openingBalance, @PathParam("sortCode") String sortCode, @PathParam("customerPassword") String customerPassword) {

        Customer customer = bankService.openCustomerAccount(customerID, accountType, accountNumber, openingBalance, sortCode, customerPassword);
        return customer;
    }

    // curl -vi -X GET -G "http://localhost:49000/api/bank/closecustomeraccount/0/83232/darylhowe"
    // curl -vi -X GET -G "http://localhost:49000/api/bank/closecustomeraccount/{customerID}/{accountNumber}/{customerPassword}"
    // Close customer account (JSON).
    @DELETE
    @Path("/closecustomeraccount/{customerID}/{accountNumber}/{customerPassword}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response closeCustomerAccountJSON(@PathParam("customerID") int customerID, @PathParam("accountNumber") int accountNumber, @PathParam("customerPassword") String customerPassword) {

        Gson gson = new Gson();
        Customer customer = bankService.closeCustomerAccount(customerID, accountNumber, customerPassword);
        return Response.status(Response.Status.CREATED).entity(gson.toJson(customer)).build();
    }

    // Close customer account (XML).
    @DELETE
    @Path("/closecustomeraccount/{customerID}/{accountNumber}/{customerPassword}")
    @Produces(MediaType.APPLICATION_XML)
    public Customer closeCustomerAccountXML(@PathParam("customerID") int customerID, @PathParam("accountNumber") int accountNumber, @PathParam("customerPassword") String customerPassword) {

        Customer customer = bankService.closeCustomerAccount(customerID, accountNumber, customerPassword);
        return customer;
    }

    
    // curl -vi -X GET -G "http://localhost:49000/api/bank/getcustomerdetails/0/darylhowe"
    // curl -vi -X GET -G "http://localhost:49000/api/bank/getcustomerdetails/{customerId}/{customerPassword}"
    // Get customer details (JSON).
    @GET
    @Path("/getcustomerdetails/{customerId}/{customerPassword}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomerDetailsJSON(@PathParam("customerId") int customerId, @PathParam("customerPassword") String customerPassword) {
        
        Gson gson = new Gson();
        Customer customer = bankService.getCustomerDetails(customerId, customerPassword);
        return Response.status(Response.Status.CREATED).entity(gson.toJson(customer)).build();
    }
    
    // Get customer details (XML).
    @GET
    @Path("/getcustomerdetails/{customerId}/{customerPassword}")
    @Produces(MediaType.APPLICATION_XML)
    public Customer getCustomerDetailsXML(@PathParam("customerID") int customerId, @PathParam("customerPassword") String customerPassword) {
        Customer customer = bankService.getCustomerDetails(customerId, customerPassword);
        return customer;
    }
    
    
    // curl -vi -X GET -G "http://localhost:49000/api/bank/getcustomeraccounts/0/darylhowe"
    // curl -vi -X GET -G "http://localhost:49000/api/bank/getcustomeraccounts/{customerId}/{customerPassword}"
    // Get customer accounts (JSON).
    @GET
    @Path("/getcustomeraccounts/{customerId}/{customerPassword}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomerAccountsJSON(@PathParam("customerId") int customerId, @PathParam("customerPassword") String customerPassword) {

        Gson gson = new Gson();
        List<Account> account = bankService.getCustomerAccounts(customerId, customerPassword);
        return Response.status(Response.Status.CREATED).entity(gson.toJson(account)).build();
    }
    
    
    // Get customer accounts (XML).
    @GET
    @Path("/getcustomeraccounts/{customerId}/{customerPassword}")
    @Produces(MediaType.APPLICATION_XML)
    public List<Account> getCustomerAccountsXML(@PathParam("customerId") int customerId, @PathParam("customerPassword") String customerPassword) {
        List<Account> account = bankService.getCustomerAccounts(customerId, customerPassword);
        return account;
    }


    // ******** ACCOUNT *******
    // curl -vi -X GET -G "http://localhost:49000/api/bank/getaccountdetails/{customerId}/{accountNumber}/{customerPassword}"
    // curl -vi -X GET -G "http://localhost:49000/api/bank/getaccountdetails/0/41324/darylhowe"
    
    @GET
    @Path("/getaccountdetails/{customerId}/{accountNumber}/{customerPassword}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAccountDetailsJSON(@PathParam("customerId") int customerId, @PathParam("accountNumber") int accountNumber, @PathParam("customerPassword") String customerPassword) {
        
        Gson gson = new Gson();
        Account account = bankService.getAccountDetails(customerId, accountNumber, customerPassword);
        return Response.status(Response.Status.CREATED).entity(gson.toJson(account)).build();
    }
    
    @GET
    @Path("/getaccountdetails/{customerId}/{accountNumber}/{customerPassword}")
    @Produces(MediaType.APPLICATION_XML)
    public Account getAccountDetailsXML(@PathParam("customerId") int customerId, @PathParam("accountNumber") int accountNumber, @PathParam("customerPassword") String customerPassword) {
        Account account = bankService.getAccountDetails(customerId, accountNumber, customerPassword);
        return account;
    }

    // curl -vi -X GET -G "http://localhost:49000/api/bank/getaccountbalance/0/41324/darylhowe"
    // curl -vi -X GET -G "http://localhost:49000/api/bank/getaccountbalance/{customerId}/{accountNumber}/{customerPassword}"
    @GET
    @Path("/getaccountbalance/{customerId}/{accountNumber}/{customerPassword}")
    public double getAccountBalance(@PathParam("customerId") int customerId, @PathParam("accountNumber") int accountNumber, @PathParam("customerPassword") String customerPassword) {
        double balance = bankService.getAccountBalance(customerId, accountNumber, customerPassword);
        return balance;
    }


    // curl -vi -X GET -G "http://localhost:49000/api/bank/getaccountsortcode/0/41324/darylhowe"
    // curl -vi -X GET -G "http://localhost:49000/api/bank/getaccountsortcode/{customerId}/{accountNumber}/{customerPassword}"
    @GET
    @Path("/getaccountsortcode/{customerId}/{accountNumber}/{customerPassword}")
    public String getAccountSortCode(@PathParam("customerId") int customerId, @PathParam("accountNumber") int accountNumber, @PathParam("customerPassword") String customerPassword) {
        String sortCode = bankService.getAccountSortCode(customerId, accountNumber, customerPassword);
        return sortCode;
    }

    // curl -vi -X GET -G "http://localhost:49000/api/bank/getaccounttype/0/41324/darylhowe"
    // curl -vi -X GET -G "http://localhost:49000/api/bank/getaccounttype/{customerId}/{accountNumber}/{customerPassword}"
    @GET
    @Path("/getaccounttype/{customerId}/{accountNumber}/{customerPassword}")
    public String getAccountType(@PathParam("customerId") int customerId, @PathParam("accountNumber") int accountNumber, @PathParam("customerPassword") String customerPassword) {
        String accountType = bankService.getAccountType(customerId, accountNumber, customerPassword);
        return accountType;
    }
    
    // ** DESCRIPTION ADDED - Add to ERD **
    // curl -vi -X GET -G "http://localhost:49000/api/bank/deposit/0/41324/darylhowe/1000/LotteryWinnings"
    // curl -vi -X GET -G "http://localhost:49000/api/bank/deposit/{customerId}/{accountNumber}/{customerPassword}/{depositAmount}/{description}"
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/deposit/{customerId}/{accountNumber}/{customerPassword}/{depositAmount}/{description}")
    public Response depositJSON(@PathParam("customerId") int customerId, @PathParam("accountNumber") int accountNumber, @PathParam("customerPassword") String customerPassword, @PathParam("depositAmount") double depositAmount, @PathParam("description") String description) {

        Gson gson = new Gson();
        Transaction transaction = bankService.deposit(customerId, accountNumber, customerPassword, depositAmount, description);
        return Response.status(Response.Status.CREATED).entity(gson.toJson(transaction)).build();
    }
    
    @POST
    @Produces(MediaType.APPLICATION_XML)
    @Path("/deposit/{customerId}/{accountNumber}/{customerPassword}/{depositAmount}/{description}")
    public Transaction depositXML(@PathParam("customerId") int customerId, @PathParam("accountNumber") int accountNumber, @PathParam("customerPassword") String customerPassword, @PathParam("depositAmount") double depositAmount, @PathParam("description") String description) {

        Transaction transaction = bankService.deposit(customerId, accountNumber, customerPassword, depositAmount, description);
        return transaction;
    }
    
    // ** DESCRIPTION ADDED - Add to ERD **
    // curl -vi -X GET -G "http://localhost:49000/api/bank/withdraw/0/41324/darylhowe/1000/OfficeEquipment"
    // curl -vi -X GET -G "http://localhost:49000/api/bank/withdraw/{customerId}/{accountNumber}/{customerPassword}/{depositAmount}/{description}"
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/withdraw/{customerId}/{accountNumber}/{customerPassword}/{withdrawAmount}/{description}")
    public Response withdrawJSON(@PathParam("customerId") int customerId, @PathParam("accountNumber") int accountNumber, @PathParam("customerPassword") String customerPassword, @PathParam("withdrawAmount") double withdrawAmount, @PathParam("description") String description) {
        Gson gson = new Gson();
        Transaction transaction = bankService.withdraw(customerId, accountNumber, customerPassword, withdrawAmount, description);
        return Response.status(Response.Status.CREATED).entity(gson.toJson(transaction)).build();
    }
    
    @POST
    @Produces(MediaType.APPLICATION_XML)
    @Path("/withdraw/{customerId}/{accountNumber}/{customerPassword}/{withdrawAmount}/{description}")
    public Transaction withdrawXML(@PathParam("customerId") int customerId, @PathParam("accountNumber") int accountNumber, @PathParam("customerPassword") String customerPassword, @PathParam("withdrawAmount") double withdrawAmount, @PathParam("description") String description) {
        Transaction transaction = bankService.withdraw(customerId, accountNumber, customerPassword, withdrawAmount, description);
        return transaction;
    }
    

    // curl -vi -X GET -G "http://localhost:49000/api/bank/transfer/83232/41324/500/0/0/darylhowe/TestTransfer"
    // curl -vi -X GET -G "http://localhost:49000/api/bank/transfer/{accountNumberSender}/{accountNumberReciever}/{transferAmount}/{customerIdSender}/{customerIdReciever}/{customerPasswordSender}//{description}"
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/transfer/{accountNumberSender}/{accountNumberReciever}/{transferAmount}/{customerIdSender}/{customerIdReciever}/{customerPasswordSender}/{description}")
    public Response transferJSON(@PathParam("accountNumberSender") int accountNumberSender, @PathParam("accountNumberReciever") int accountNumberReciever, @PathParam("transferAmount") double transferAmount, @PathParam("customerIdSender") int customerIdSender, @PathParam("customerIdReciever") int customerIdReciever, @PathParam("customerPasswordSender") String customerPasswordSender, @PathParam("description") String description) {
        Gson gson = new Gson();
        List<Transaction> transactionList = bankService.transfer(accountNumberSender, accountNumberReciever, transferAmount, customerIdSender, customerIdReciever, customerPasswordSender, description);
        return Response.status(Response.Status.CREATED).entity(gson.toJson(transactionList)).build();
    }
    
    @POST
    @Produces(MediaType.APPLICATION_XML)
    @Path("/transfer/{accountNumberSender}/{accountNumberReciever}/{transferAmount}/{customerIdSender}/{customerIdReciever}/{customerPasswordSender}/{description}")
    public List<Transaction> transferXML(@PathParam("accountNumberSender") int accountNumberSender, @PathParam("accountNumberReciever") int accountNumberReciever, @PathParam("transferAmount") double transferAmount, @PathParam("customerIdSender") int customerIdSender, @PathParam("customerIdReciever") int customerIdReciever, @PathParam("customerPasswordSender") String customerPasswordSender, @PathParam("description") String description) {
        List<Transaction> transactionList = bankService.transfer(accountNumberSender, accountNumberReciever, transferAmount, customerIdSender, customerIdReciever, customerPasswordSender, description);
        return transactionList;
    }
    
    // curl -vi -X GET -G "http://localhost:49000/api/bank/getaccounthistory/0/83232/darylhowe"
    // curl -vi -X GET -G "http://localhost:49000/api/bank/getaccounthistory/{customerId}/{accountNumber}/{customerPassword}"
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getaccounthistory/{customerId}/{accountNumber}/{customerPassword}")
    public Response getAccountHistoryJSON(@PathParam("customerId") int customerId, @PathParam("accountNumber") int accountNumber, @PathParam("customerPassword") String customerPassword) {
        Gson gson = new Gson();
        List<Transaction> accountHistory = bankService.getAccountHistory(customerId, accountNumber, customerPassword);
        return Response.status(Response.Status.CREATED).entity(gson.toJson(accountHistory)).build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/getaccounthistory/{customerId}/{accountNumber}/{customerPassword}")
    public List<Transaction> getAccountHistoryXML(@PathParam("customerId") int customerId, @PathParam("accountNumber") int accountNumber, @PathParam("customerPassword") String customerPassword) {
        List<Transaction> accountHistory = bankService.getAccountHistory(customerId, accountNumber, customerPassword);
        return accountHistory;
    }

    
    
    
    
    // ******** TRANSACTION *******
    
    // curl -vi -X GET -G "http://localhost:49000/api/bank/gettransactionbyid/0/83232/darylhowe/{transactionId}"
    // curl -vi -X GET -G "http://localhost:49000/api/bank/gettransactionbyid/{customerId}/{accountNumber}/{customerPassword}/{transactionId}"
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/gettransactionbyid/{customerId}/{accountNumber}/{customerPassword}/{transactionId}")
    public Response getTransactionByIdJSON(@PathParam("customerId") int customerId, @PathParam("accountNumber") int accountNumber, @PathParam("customerPassword") String customerPassword, @PathParam("transactionId") String transactionId) {
        Gson gson = new Gson();
        Transaction transaction = bankService.getTransactionById(customerId, accountNumber, customerPassword, transactionId);
        return Response.status(Response.Status.CREATED).entity(gson.toJson(transaction)).build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/gettransactionbyid/{customerId}/{accountNumber}/{customerPassword}/{transactionId}")
    public Transaction getTransactionByIdXML(@PathParam("customerId") int customerId, @PathParam("accountNumber") int accountNumber, @PathParam("customerPassword") String customerPassword, @PathParam("transactionId") String transactionId) {
        Transaction transaction = bankService.getTransactionById(customerId, accountNumber, customerPassword, transactionId);
        return transaction;
    }
}

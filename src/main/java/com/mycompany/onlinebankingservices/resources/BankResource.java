package com.mycompany.onlinebankingservices.resources;

import com.google.gson.Gson;
import com.mycompany.onlinebankingservice.service.BankingService;
import com.mycompany.onlinebankingservices.model.Account;
import com.mycompany.onlinebankingservices.model.Customer;
import com.mycompany.onlinebankingservices.model.Transaction;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/bank")
public class BankResource {

    private BankingService bankService = new BankingService();

    // http://localhost:49000/api/bank/test
    @GET
    @Path("/test")
    public String test() {
        return "Hello world";
    }

    // NOTE: This should be called only once every time application is restarted.
    // http://localhost:49000/api/bank/createpastcustomers
    @GET
    @Path("/createpastcustomers")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPastCustomers() {

        Gson gson = new Gson();
        List<Customer> customersList = bankService.createPastCustomers();
        return Response.status(Response.Status.CREATED).entity(gson.toJson(customersList)).build();
    }

    // ******** ACCOUNT *******
    // http://localhost:49000/api/bank/getaccountdetails/{customerId}/{accountNumber}/{customerPassword}
    // http://localhost:49000/api/bank/getaccountdetails/0/41324/darylhowe
    @GET
    @Path("/getaccountdetails/{customerId}/{accountNumber}/{customerPassword}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAccountDetails(@PathParam("customerId") int customerId, @PathParam("accountNumber") int accountNumber, @PathParam("customerPassword") String customerPassword) {
        Gson gson = new Gson();
        Account account = bankService.getAccountDetails(customerId, accountNumber, customerPassword);
        return Response.status(Response.Status.CREATED).entity(gson.toJson(account)).build();
    }

    // http://localhost:49000/api/bank/getaccountbalance/0/41324/darylhowe
    // http://localhost:49000/api/bank/getaccountbalance/{customerId}/{accountNumber}/{customerPassword}
    @GET
    @Path("/getaccountbalance/{customerId}/{accountNumber}/{customerPassword}")
    public double getAccountBalance(@PathParam("customerId") int customerId, @PathParam("accountNumber") int accountNumber, @PathParam("customerPassword") String customerPassword) {
        double balance = bankService.getAccountBalance(customerId, accountNumber, customerPassword);
        return balance;
    }

    // http://localhost:49000/api/bank/getaccountsortcode/0/41324/darylhowe
    // http://localhost:49000/api/bank/getaccountsortcode/{customerId}/{accountNumber}/{customerPassword}
    @GET
    @Path("/getaccountsortcode/{customerId}/{accountNumber}/{customerPassword}")
    public String getAccountSortCode(@PathParam("customerId") int customerId, @PathParam("accountNumber") int accountNumber, @PathParam("customerPassword") String customerPassword) {
        String sortCode = bankService.getAccountSortCode(customerId, accountNumber, customerPassword);
        return sortCode;
    }

    // http://localhost:49000/api/bank/getaccounttype/0/41324/darylhowe
    // http://localhost:49000/api/bank/getaccounttype/{customerId}/{accountNumber}/{customerPassword}
    @GET
    @Path("/getaccounttype/{customerId}/{accountNumber}/{customerPassword}")
    public String getAccountType(@PathParam("customerId") int customerId, @PathParam("accountNumber") int accountNumber, @PathParam("customerPassword") String customerPassword) {
        String accountType = bankService.getAccountType(customerId, accountNumber, customerPassword);
        return accountType;
    }
    
    // ** DESCRIPTION ADDED - Add to ERD **
    // http://localhost:49000/api/bank/deposit/0/41324/darylhowe/1000/OfficeEquipment
    // http://localhost:49000/api/bank/deposit/{customerId}/{accountNumber}/{customerPassword}/{depositAmount}/{description}
    @POST
    @Path("/deposit/{customerId}/{accountNumber}/{customerPassword}/{depositAmount}/{description}")
    public Response deposit(@PathParam("customerId") int customerId, @PathParam("accountNumber") int accountNumber, @PathParam("customerPassword") String customerPassword, @PathParam("depositAmount") double depositAmount, @PathParam("description") String description) {

        Gson gson = new Gson();
        Transaction transaction = bankService.deposit(customerId, accountNumber, customerPassword, depositAmount, description);
        return Response.status(Response.Status.CREATED).entity(gson.toJson(transaction)).build();
    }
    
    // ** DESCRIPTION ADDED - Add to ERD **
    // http://localhost:49000/api/bank/withdraw/0/41324/darylhowe/1000/OfficeEquipment
    // http://localhost:49000/api/bank/withdraw/{customerId}/{accountNumber}/{customerPassword}/{depositAmount}/{description}
    @POST
    @Path("/withdraw/{customerId}/{accountNumber}/{customerPassword}/{withdrawAmount}/{description}")
    public Response withdraw(@PathParam("customerId") int customerId, @PathParam("accountNumber") int accountNumber, @PathParam("customerPassword") String customerPassword, @PathParam("withdrawAmount") double withdrawAmount, @PathParam("description") String description) {
        Gson gson = new Gson();
        Transaction transaction = bankService.withdraw(customerId, accountNumber, customerPassword, withdrawAmount, description);
        return Response.status(Response.Status.CREATED).entity(gson.toJson(transaction)).build();
    }

}

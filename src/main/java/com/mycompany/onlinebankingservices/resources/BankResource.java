package com.mycompany.onlinebankingservices.resources;

import com.mycompany.onlinebankingservice.service.BankingService;
import com.mycompany.onlinebankingservices.model.Account;
import com.mycompany.onlinebankingservices.model.Customer;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/bank")
public class BankResource {

    BankingService bankService;
    
    // http://localhost:49000/api/bank/test
    
    @GET
    @Path("/test")
    public String test() {
        return "Hello world";
    }
    
    @GET
    @Path("/createpastcustomers")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> createPastCustomers() {

        return bankService.createPastCustomers();
    }
    
    // ******** ACCOUNT *******
    @GET
    @Path("/getaccountdetails/{customerId}/{accountNumber}/{accountPassword}")
    public Account getAccountDetails(){
        Account account = null;
        
        return account;
                
    }
   
}

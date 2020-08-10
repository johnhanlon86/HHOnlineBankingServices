package com.mycompany.onlinebankingservices.resources;

import com.google.gson.Gson;
import com.mycompany.onlinebankingservice.service.BankingService;
import com.mycompany.onlinebankingservices.model.Account;
import com.mycompany.onlinebankingservices.model.Customer;
import java.util.List;
import javax.ws.rs.GET;
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

}

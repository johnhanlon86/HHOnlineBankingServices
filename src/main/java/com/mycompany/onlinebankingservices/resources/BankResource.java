package com.mycompany.onlinebankingservices.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/bank")
public class BankResource {

    // http://localhost:49000/api/bank/test
    
    @GET
    @Path("/test")
    public String test() {
        return "Hello world";
    }
}

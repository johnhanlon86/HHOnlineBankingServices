package com.mycompany.onlinebankingservices.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/bank")
public class BankResource {

    @GET
    @Path("/test")
    public String test() {

        return "Hello world";
    }
}

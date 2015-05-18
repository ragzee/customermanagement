/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.resource;

import com.mycompany.model.Customer;
import com.mycompany.service.CustomerService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * Resource implementation to create/update/fetch the customer
 */
@Service
@Path("/customer")
public class CustomerResource {
    
    private final Logger logger = LoggerFactory.getLogger(CustomerResource.class);
    
    @Autowired
    private CustomerService customerService;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Customer customer) {
        
        if(customerService.createCustomer(customer).isPresent()) {
            return Response.ok().build();
        } else
        return Response.status(Response.Status.BAD_REQUEST).entity(new Error(1,"test")).build();
    } 
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        logger.debug("Received request to fetch all the customers.");
        List<Customer> customers = customerService.fetchAll();
        GenericEntity<List<Customer>> customerEntities = new GenericEntity<List<Customer>>(customers) {};
        return Response.ok(customerEntities).build();
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Customer customer) {
        return Response.status(Response.Status.NO_CONTENT).build();
    } 
}


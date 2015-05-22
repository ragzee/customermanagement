/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.api;

import com.mycompany.model.fx.FxQuote;
import com.mycompany.service.event.EventLogger;
import com.mycompany.service.fx.ForeignExchangeService;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author paliwala
 */
@Service
@Path("/foreignexchange")
public class ForeignExchange {
    
    private final Logger logger = LoggerFactory.getLogger(ForeignExchange.class);
     
    @Autowired
    private ForeignExchangeService fxService;
    
    private EventLogger eventLogger;
    
    @GET
    @Path("/curriencies")
    @Produces(MediaType.APPLICATION_JSON)
    public Response supportedCurrencies(@Context HttpHeaders hh) {
        logger.debug("Received request to fetch the supported currencies from user agent : " + hh.getRequestHeader("user-agent"));
        return Response.ok(fxService.getSupportedCurriencies()).build();
    }
    
    @GET
    @Path("/quote")
    @Produces(MediaType.APPLICATION_JSON)
    public Response generateQuote(@NotNull @Size(min=3) @QueryParam("sourceCurrency") String sourceCurrency, 
            @NotNull @QueryParam("destinationCurrency") String destinationCurrency, 
            @QueryParam("amount") String amount) {
        logger.debug("Received request to generate fx quote. ");
        return Response.ok(fxService.generateFXQuote(sourceCurrency, destinationCurrency, amount)).build();
    }
    
    @POST
    @Path("/quote")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveQuote(FxQuote quote) {
        return Response.ok(fxService.saveFXQuote(quote)).build();
    }    
}

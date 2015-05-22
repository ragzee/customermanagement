/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model.event;

import com.mycompany.model.fx.FxQuote;
import java.util.UUID;

/**
 *
 * @author paliwala
 */
public class GenerateQuoteEvent extends Event{
    
    private FxQuote quote;
    private long customerId;
    
    public GenerateQuoteEvent(String description, FxQuote quote, long customerId){
        super(UUID.randomUUID().timestamp(), EventType.GENERATE_FX_QUOTE, description);
        this.quote = quote;
        this.customerId = customerId;
    }
}

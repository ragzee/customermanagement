/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model.event;

import com.mycompany.common.IdUtils;
import com.mycompany.model.fx.FxQuote;

/**
 *
 */
public class PersistQuoteEvent extends Event {
    private FxQuote fxQuote;
    private long customerId;

    public PersistQuoteEvent(FxQuote quote, long customerId) {
        super(IdUtils.getID(), EventType.SAVE_FX_QUOTE, "Saving quote");
        this.fxQuote = fxQuote;
        this.customerId = customerId;
    }

    public FxQuote getFxQuote() {
        return fxQuote;
    }
 
}

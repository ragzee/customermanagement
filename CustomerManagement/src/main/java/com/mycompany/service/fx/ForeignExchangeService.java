/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service.fx;

import com.mycompany.model.fx.FxQuote;
import java.util.List;

/**
 * Service to expose the Foreign Exchange APIs
 * 
 */
public interface ForeignExchangeService {
    
    /**
     * Return the list of the supported currencies
     * @return Currency
     */
    List<com.mycompany.model.fx.Currency> getSupportedCurriencies();
    
    /**
     * API to calculate the amount in the source currency and destination currency 
     * as per the current mid market rate
     * @param sourceCurrency
     * @param destinationCurrency
     * @param amount
     * @return 
     */
    FxQuote generateFXQuote(String sourceCurrency, String destinationCurrency, String amount);
    
    
    /**
     * API to lock the fx quote.
     * @param fxQuote
     * @return fxQuote
     */
    FxQuote saveFXQuote(FxQuote fxQuote);
}

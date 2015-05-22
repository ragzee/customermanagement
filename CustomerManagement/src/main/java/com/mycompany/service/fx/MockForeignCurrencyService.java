/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service.fx;

import com.mycompany.common.IdUtils;
import com.mycompany.model.fx.Currency;
import com.mycompany.model.fx.FxQuote;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 * Mock implementation of the FX currency API
 */
@Service
public class MockForeignCurrencyService implements ForeignExchangeService{

    private static List<Currency> supportedCurrencies = new ArrayList<Currency>();
    static{
       supportedCurrencies.add(new Currency("GBP", "Great British Pound", 2));
       supportedCurrencies.add(new Currency("USD", "American Dollars", 2));
       supportedCurrencies.add(new Currency("EUR", "Euros", 2));
       supportedCurrencies.add(new Currency("INR", "Indian Rupees", 2));
       supportedCurrencies.add(new Currency("DKK", "Danish Krone", 2));
       supportedCurrencies.add(new Currency("JPY", "Japanese Yen", 0));
       supportedCurrencies.add(new Currency("UAH", "Ukrainian Hryvnia", 2));
    }
    
    private Map<Long, FxQuote> savedQuotes = new HashMap<Long, FxQuote>();
    
    @Override
    public List<Currency> getSupportedCurriencies() {
        return supportedCurrencies;
    }

    @Override
    public FxQuote generateFXQuote(String sourceCurrencyCode, String destinationCurrencyCode, String amount) {
        double rate = 3.12;
        Double amountInDestinationCurrency = null;
        if(amount != null) {
            amountInDestinationCurrency = Double.valueOf(amount) * rate;
        }
        return new FxQuote(IdUtils.getID(), sourceCurrencyCode, destinationCurrencyCode, "3.123", amount, amountInDestinationCurrency.toString());
    }

    @Override
    public FxQuote saveFXQuote(FxQuote fxQuote) {
        savedQuotes.put(fxQuote.getId(), fxQuote);
        return fxQuote;
    }
    
}

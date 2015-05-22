/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model.fx;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author paliwala
 */
public class FxQuote {
    private long id;
    private String conversionId;
    @NotNull @Size(min=3, max=3)
    private String sourceCurrencyCode;
    @NotNull @Size(min=3, max=3)
    private String destinationCurrencyCode;
    @NotNull
    private String midMarketRate;
    private String amountInSourceCurrency;
    private String amountInDestinationCurrency;

    public FxQuote(){
    }
    
    public FxQuote(long id, String sourceCurrency, String destinationCurrency, String midMarketRate, String amountInSourceCurrency, String amountInDestinationCurrency) {
        this.id = id;
        this.sourceCurrencyCode = sourceCurrency;
        this.destinationCurrencyCode = destinationCurrency;
        this.midMarketRate = midMarketRate;
        this.amountInSourceCurrency = amountInSourceCurrency;
        this.amountInDestinationCurrency = amountInDestinationCurrency;
    }

   
    @Override
    public String toString() {
        return "FxQuote{" + "conversionid=" + conversionId + "," + "id=" + id + ", sourceCurrency=" + sourceCurrencyCode + ", destinationCurrency=" + destinationCurrencyCode + ", midMarketRate=" + midMarketRate + ", amountInSourceCurrency=" + amountInSourceCurrency + ", amountInDestinationCurrency=" + amountInDestinationCurrency + '}';
    }

    public long getId() {
        return id;
    }

    public String getConversionId() {
        return conversionId;
    }

    public String getSourceCurrency() {
        return sourceCurrencyCode;
    }

    public String getDestinationCurrency() {
        return destinationCurrencyCode;
    }

    public String getMidMarketRate() {
        return midMarketRate;
    }

    public String getAmountInSourceCurrency() {
        return amountInSourceCurrency;
    }

    public String getAmountInDestinationCurrency() {
        return amountInDestinationCurrency;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setConversionId(String conversionId) {
        this.conversionId = conversionId;
    }

    public void setSourceCurrency(String sourceCurrency) {
        this.sourceCurrencyCode = sourceCurrency;
    }

    public void setDestinationCurrency(String destinationCurrency) {
        this.destinationCurrencyCode = destinationCurrency;
    }

    public void setMidMarketRate(String midMarketRate) {
        this.midMarketRate = midMarketRate;
    }

    public void setAmountInSourceCurrency(String amountInSourceCurrency) {
        this.amountInSourceCurrency = amountInSourceCurrency;
    }

    public void setAmountInDestinationCurrency(String amountInDestinationCurrency) {
        this.amountInDestinationCurrency = amountInDestinationCurrency;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.data;

import com.mycompany.model.fx.FxQuote;

/**
 * APIs store/fetch the Foreign exchange data
 */
public interface FxData {
    
    void saveQuote(FxQuote quote);
    
}

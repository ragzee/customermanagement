/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.model.fx.FxQuote;
import com.mycompany.service.fx.ForeignExchangeService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * To test Foreign exchange service
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/META-INF/spring-cxf.xml")
public class TestForeignExchangeService {
    
    @Autowired
    @InjectMocks
    private ForeignExchangeService fxService;
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void generateQuote() {
        FxQuote quote = fxService.generateFXQuote("GBP", "USD", "123.00");
        Assert.assertNotNull(" Quote object should not be Null " + quote);
        Assert.assertNotNull(" Quote id is not populated " + quote.getId());
    }
}

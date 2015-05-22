/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exception;

import java.util.HashSet;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.junit.Test;
import javax.ws.rs.core.Response;
import junit.framework.Assert;
import org.hibernate.validator.internal.engine.ConstraintViolationImpl;

/**
 *
 * @author paliwala
 */
public class ConstraintViolationExceptionHandlerTest {
    
    @Test
    public void testSuccess() throws Exception {
        ConstraintViolationExceptionHandler exceptionHandler = new ConstraintViolationExceptionHandler();
        ConstraintViolationException violationException = new ConstraintViolationException(new HashSet<ConstraintViolation<?>>());
        Response response = exceptionHandler.toResponse(violationException);
        Assert.assertNotSame(Response.Status.ACCEPTED.getStatusCode(), response.getStatus());
    }
    
    @Test
    public void testBadRequestStatus() throws Exception {
        ConstraintViolationExceptionHandler exceptionHandler = new ConstraintViolationExceptionHandler();
        Set<ConstraintViolation<?>> violations = new HashSet();
        
        ConstraintViolationException violationException = new ConstraintViolationException(new HashSet<ConstraintViolation<?>>());
        Response response = exceptionHandler.toResponse(violationException);
        Assert.assertSame(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * To suppress default 500 error 
 */
public class ConstraintViolationExceptionHandler implements ExceptionMapper<ConstraintViolationException>{

    private Logger logger = LoggerFactory.getLogger(ConstraintViolationExceptionHandler.class);
    
    @Override
    public Response toResponse(ConstraintViolationException exception) {
        Set<ConstraintViolation<?>> constraintViolations = exception.getConstraintViolations();
        List<Error> violations = new ArrayList<>();
        long counter = 1;
        for(ConstraintViolation<?> c : constraintViolations) {
            Error error = new Error(counter++, c.getMessage());
            violations.add(error);
            logger.debug(" getMessage : " + c.getMessage());
            logger.debug(" getMessageTemplate : " + c.getMessageTemplate());
            logger.debug(" getPropertyPath : " + c.getPropertyPath());
        }
        
        return Response.status(Response.Status.BAD_REQUEST)
                       .entity(violations)
                       .build();
    }
    
}

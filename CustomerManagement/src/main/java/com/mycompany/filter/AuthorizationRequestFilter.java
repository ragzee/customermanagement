/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.filter;

import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import org.apache.commons.lang.StringUtils;
 
/**
 * Filter to authorize the incoming request. Current implementation just checks if the header element exists,
 * More sophisticated implementation will be to invoke the Identity Service to validate the incoming token,
 */
public class AuthorizationRequestFilter implements ContainerRequestFilter {
 
    @Override
    public void filter(ContainerRequestContext requestContext)
                    throws IOException {
        String token = requestContext.getHeaderString("Authorization");
        
        if (StringUtils.isBlank(token)) {
 
            requestContext.abortWith(Response
                .status(Response.Status.UNAUTHORIZED)
                .entity("User cannot access the resource.")
                .build());
        }
    }
}
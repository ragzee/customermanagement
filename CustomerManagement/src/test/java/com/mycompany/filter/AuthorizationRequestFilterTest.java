/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.filter;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import org.junit.After;
import org.junit.Test;
import static org.mockito.Mockito.*;

/**
 * To test the AuthorizationRequest filter
 */
public class AuthorizationRequestFilterTest {
   
    @After
    public void validate() {
        validateMockitoUsage();
    }
    
    @Test
    public void testFilterWithValidHeader() throws Exception{
        AuthorizationRequestFilter filter = new AuthorizationRequestFilter();
        ContainerRequestContext context = mock( ContainerRequestContext.class );
        when(context.getHeaderString(HttpHeaders.AUTHORIZATION)).thenReturn("Bearer sdhfkjdshfkdshfk");

        filter.filter(context);
        Response r = Response
            .status(Response.Status.UNAUTHORIZED)
            .entity("User cannot access the resource.")
            .build(); 
        verify(context, times(1)).getHeaderString(HttpHeaders.AUTHORIZATION);
        verify(context, never()).abortWith(r);
    }
    
   // @Test
    public void testNullHeader() throws Exception {
        AuthorizationRequestFilter filter = new AuthorizationRequestFilter();
        ContainerRequestContext context = mock( ContainerRequestContext.class );
        when(context.getHeaderString(HttpHeaders.AUTHORIZATION)).thenReturn(null);

        filter.filter(context);
        verify(context, times(1)).abortWith((Response)any());

    }
    
    @Test
    public void testEmptyHeader() throws Exception {
        AuthorizationRequestFilter filter = new AuthorizationRequestFilter();
        ContainerRequestContext context = mock( ContainerRequestContext.class );
        when(context.getHeaderString(HttpHeaders.AUTHORIZATION)).thenReturn(" ");

        filter.filter(context);
        verify(context, times(1)).abortWith((Response)any());
    }
}

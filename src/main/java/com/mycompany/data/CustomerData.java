/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.data;

import com.mycompany.model.Customer;
import java.util.List;
import java.util.Optional;

/**
 *
 * Methods to create/modify/fetch customer data
 */
public interface CustomerData {
    
    Optional<Customer> createCustomer(Customer customer);
    
    List<Customer> fetchAll();
    
    void updateCustomer(Customer customer);
}

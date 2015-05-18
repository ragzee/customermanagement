/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.model.Customer;
import java.util.List;
import java.util.Optional;

/**
 *
 * Interface to provide CRUD operations on customer.
 */
public interface CustomerService {
    
    Optional<Customer> createCustomer(Customer customer);
    
    List<Customer> fetchAll();
    
    void updateCustomer(Customer customer);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service.customer;

import com.mycompany.data.CustomerData;
import com.mycompany.model.Customer;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author paliwala
 */
@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerData customerData;
    
    @Override
    public Optional<Customer> createCustomer(Customer customer) {
        return customerData.createCustomer(customer);
    }

    @Override
    public List<Customer> fetchAll() {
        return customerData.fetchAll();
    }

    @Override
    public void updateCustomer(Customer customer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

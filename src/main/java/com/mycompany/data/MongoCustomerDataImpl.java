/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.data;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mycompany.data.utils.Utils;
import com.mycompany.model.Customer;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * MongoDB to store customer data
 */
public class MongoCustomerDataImpl implements CustomerData{

    private static final Logger logger = LoggerFactory.getLogger(MongoCustomerDataImpl.class);
    
    private MongoClient mongoClient;
    private String dbName;
    private String collectionName;
    private DBCollection customerCollection;
    
    public MongoCustomerDataImpl(){}

    public void setMongoClient(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public void setCustomerCollection(DBCollection customerCollection) {
        this.customerCollection = customerCollection;
    }
    
    public void init() {
        DB customerDatabase = mongoClient.getDB(dbName);
        customerCollection = customerDatabase.getCollection(collectionName);
    }
    
    @Override
    public Optional<Customer> createCustomer(@NotNull final Customer customer) {
        logger.debug(" Inserting customer in the data store : " + customer);
        customerCollection.insert(Utils.convertPOJOtoDBObject(customer));
        return Optional.of(customer);
    }

    @Override
    public List<Customer> fetchAll() {
        final List<Customer> customers = new ArrayList<Customer>();
        DBCursor cursor = customerCollection.find();
        
        try {
                while(cursor.hasNext()) {
                    DBObject db = cursor.next();
                    customers.add((Customer)Utils.convertDBObjectToPOJO(db, Customer.class));
                }
        } finally {
            logger.info("Closing connection.");
        }
        return customers;
    }

    @Override
    public void updateCustomer(Customer customer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

package com.agile.demo.service;
import com.agile.demo.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer createCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    List<Customer> getAllCustomers();
    Customer getCustomerById(long customerId);
    void deleteCustomer(Customer customer);


}

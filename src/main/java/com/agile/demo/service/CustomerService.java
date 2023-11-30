package com.agile.demo.service;

import com.agile.demo.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Customer createCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    List<Customer> getAllCustomers();
    Optional<Customer> getCustomerById(String customerId);
    void deleteCustomer(String customerId);
}

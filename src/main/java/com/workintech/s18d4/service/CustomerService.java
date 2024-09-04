package com.workintech.s18d4.service;

import com.workintech.s18d4.entity.Customer;
import java.util.List;

public interface CustomerService {
    List<Customer> findAllCustomers();
    Customer findCustomerById(Long id);
    Customer saveCustomer(Customer customer);
    Customer updateCustomer(Long id, Customer customerDetails);
    void deleteCustomer(Long id);
}

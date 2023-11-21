package com.egustore.eshop.service;

import com.egustore.eshop.dto.CustomerDTO;
import com.egustore.eshop.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer createCustomer(CustomerDTO customerDTO);

    Customer getCustomerById(int id);

    List<Customer> getAllCustomers();

    Customer updateCustomer(int id, CustomerDTO customerDTO);
//    Integer updateStatusCustomer(Integer id, CustomerDTO customerDTO);

    void deleteCustomer(int id);

    String login(String email, String password) throws Exception;

    Customer getCustomerDetails(String token) throws Exception;
}

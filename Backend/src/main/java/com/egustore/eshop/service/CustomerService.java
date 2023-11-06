package com.egustore.eshop.service;

import com.egustore.eshop.dto.ChangePasswordDTO;
import com.egustore.eshop.dto.CustomerDTO;
import com.egustore.eshop.dto.ForgotPasswordDTO;
import com.egustore.eshop.dto.ResetPasswordDTO;
import com.egustore.eshop.model.Customer;

import java.util.List;

public interface CustomerService {
    void updateProfile(int id, CustomerDTO customerDTO);
    void changePassword(int id, ChangePasswordDTO changePasswordDTO);
    void forgotPassword(ForgotPasswordDTO forgotPasswordDTO);
    void resetPassword(ResetPasswordDTO resetPasswordDTO);
    Customer createCustomer(CustomerDTO customerDTO);

    Customer getCustomerById(int id);

    List<Customer> getAllCustomers();

    Customer updateCustomer(int id, CustomerDTO customerDTO);

    void deleteCustomer(int id);

    String login(String email, String password) throws Exception;
}

package com.egustore.eshop.service;

import com.egustore.eshop.dto.ChangePasswordDTO;
import com.egustore.eshop.dto.CustomerDTO;
import com.egustore.eshop.dto.ForgotPasswordDTO;
import com.egustore.eshop.dto.ResetPasswordDTO;
import com.egustore.eshop.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer createCustomer(CustomerDTO customerDTO);

    Customer getCustomerById(int id);

    Customer getCustomerDetails(String token) throws Exception;

    List<Customer> getAllCustomers();
    void updateProfile(int id, CustomerDTO customerDTO);
    void changePassword(int id, ChangePasswordDTO changePasswordDTO);
    void forgotPassword(ForgotPasswordDTO forgotPasswordDTO);
    void resetPassword(ResetPasswordDTO resetPasswordDTO);
    Customer updateCustomer(int id, CustomerDTO customerDTO);
//    Integer updateStatusCustomer(Integer id, CustomerDTO customerDTO);

    void deleteCustomer(int id);
    Integer updateStatusCustomer(CustomerDTO customerDTO,int id);

    String login(String email, String password) throws Exception;
}

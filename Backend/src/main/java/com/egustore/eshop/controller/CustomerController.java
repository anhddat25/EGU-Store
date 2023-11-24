package com.egustore.eshop.controller;

import com.egustore.eshop.dto.CustomerDTO;
import com.egustore.eshop.dto.CustomerLoginDTO;
import com.egustore.eshop.model.Customer;
import com.egustore.eshop.response.CustomerResponse;
import com.egustore.eshop.response.LoginResponse;
import com.egustore.eshop.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v0/customers")
@Validated
@CrossOrigin("*")
public class CustomerController {
    private final CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    //Create category
    @PostMapping("/register")
    public ResponseEntity<?> createCustomer(@RequestBody @Valid CustomerDTO customerDTO, BindingResult result) {
        try {
            if (result.hasErrors()) {
                List<String> errMessage = result.getFieldErrors()
                        .stream()
                        .map(FieldError::getDefaultMessage)
                        .toList();
                return ResponseEntity.badRequest().body(errMessage);
            }
            customerService.createCustomer(customerDTO);
            return ResponseEntity.ok("Register account successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid CustomerLoginDTO customerLoginDTO, BindingResult result) {
        try {
            String token = customerService.login(
                    customerLoginDTO.getEmail(),
                    customerLoginDTO.getPassword());
            return ResponseEntity.ok(LoginResponse.builder().message("Succes").token(token).build());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(LoginResponse.builder().build());
        }
    }

    //Show all categories
    @GetMapping("")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCustomer(@PathVariable int id, @RequestBody CustomerDTO customerDTO) {
        customerService.updateCustomer(id, customerDTO);
        return ResponseEntity.ok("update customer ");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable int id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.ok("delete customer " + id);
    }
    @PutMapping("/status/{id}")
    public ResponseEntity<String> updateStatusCustomer(@PathVariable int id,@RequestBody CustomerDTO customerDTO) {
        customerService.updateStatusCustomer(customerDTO, id);
        return ResponseEntity.ok("update status and role customer" + id);
    }

    @PostMapping("/details")
    public ResponseEntity<CustomerResponse> getCustomerDetails(@RequestHeader("Authorization") String token) {
        try {
            String extraToken = token.substring(7);
            Customer customer = customerService.getCustomerDetails(extraToken);
            return ResponseEntity.ok(CustomerResponse.fromCustomer(customer));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
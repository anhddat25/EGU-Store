package com.egustore.eshop.controller;

import com.egustore.eshop.dto.CustomerDTO;
import com.egustore.eshop.dto.CustomerLoginDTO;
import com.egustore.eshop.model.Customer;
import com.egustore.eshop.response.CustomerResponse;
import com.egustore.eshop.response.LoginResponse;
import com.egustore.eshop.service.CustomerService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.LocaleResolver;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/api/v0/customers")
@Validated
@CrossOrigin("*")
public class CustomerController {
    private final CustomerService customerService;
    private final MessageSource messageSource;
    private final LocaleResolver localeResolver;

    @Autowired
    public CustomerController(CustomerService customerService, MessageSource messageSource, LocaleResolver request, LocaleResolver localeResolver) {
        this.customerService = customerService;
        this.messageSource = messageSource;
        this.localeResolver = localeResolver;
    }

    //Create category
    @PostMapping("/register")
    public ResponseEntity<?> createCustomer(@RequestBody @Valid CustomerDTO customerDTO, BindingResult result)
    {
        try {
            if(result.hasErrors())
            {
                List<String> errMessage = result.getFieldErrors()
                        .stream()
                        .map(FieldError::getDefaultMessage)
                        .toList();
                return ResponseEntity.badRequest().body(errMessage);
            }
            customerService.createCustomer(customerDTO);
            return ResponseEntity.ok("Register account successfully!");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid CustomerLoginDTO customerLoginDTO, BindingResult result, HttpServletRequest request) {
        try {
            String token = customerService.login(
                    customerLoginDTO.getEmail(),
                    customerLoginDTO.getPassword());
            Locale locale = localeResolver.resolveLocale(request);
            return ResponseEntity.ok(LoginResponse.builder().message(messageSource.getMessage("customer.login.login_successfully",null,locale)).token(token).build());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(LoginResponse.builder().message(e.getMessage()).build());
        }
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


    //Show all categories
    @GetMapping("")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateCustomer(@PathVariable int id,@RequestBody CustomerDTO customerDTO) {
        customerService.updateCustomer(id,customerDTO);
        return ResponseEntity.ok("update customer ");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable int id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.ok("delete customer " + id);
    }
    @PutMapping("/status/{id}")
    public ResponseEntity<String> updateStatusCustomer(@PathVariable int id,@RequestBody CustomerDTO customerDTO) {
        customerService.updateStatusCustomer(customerDTO, id);
        return ResponseEntity.ok("update status and role customer" + id);
    }

}

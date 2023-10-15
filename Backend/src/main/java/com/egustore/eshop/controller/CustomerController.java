package com.egustore.eshop.controller;

import com.egustore.eshop.dto.CustomerDTO;
import com.egustore.eshop.dto.CustomerLoginDTO;
import com.egustore.eshop.model.Customer;
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
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
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
    public ResponseEntity<String> login(@RequestBody @Valid CustomerLoginDTO customerLoginDTODTO, BindingResult result)
    {

            return ResponseEntity.ok("Token");

    }


    //Show all categories
    @GetMapping("")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCustomer(@PathVariable int id,@RequestBody CustomerDTO customerDTO) {
        customerService.updateCustomer(id,customerDTO);
        return ResponseEntity.ok("update customer ");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable int id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.ok("delete customer " + id);
    }

}

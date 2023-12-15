package com.egustore.eshop.controller;

import com.egustore.eshop.dto.*;
import com.egustore.eshop.model.Customer;
import com.egustore.eshop.response.*;
import com.egustore.eshop.service.CustomerService;
import com.egustore.eshop.utils.LocalizationUtils;
import com.egustore.eshop.utils.MessageKeys;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.context.MessageSource;
import org.springframework.web.servlet.LocaleResolver;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v0/customers")
@CrossOrigin("*")
public class CustomerController {
    private final CustomerService customerService;
    private final LocalizationUtils localizationUtils;

    @Autowired
    public CustomerController(CustomerService customerService, MessageSource messageSource, LocaleResolver request, LocaleResolver localeResolver, LocalizationUtils localizationUtils) {
        this.customerService = customerService;
        this.localizationUtils = localizationUtils;
    }

    //Create category
    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> createCustomer(@RequestBody @Valid CustomerDTO customerDTO, BindingResult result)
    {
            try {
                if(result.hasErrors())
                {
                    List<String> errMessages = result.getFieldErrors()
                            .stream()
                            .map(FieldError -> localizationUtils.getLocalizedMessage(FieldError.getCode()))
                            .toList();
                    return ResponseEntity.badRequest().body(RegisterResponse.builder().errors(errMessages).build());
                }
                Customer customer = customerService.createCustomer(customerDTO);
                return ResponseEntity.ok(RegisterResponse.builder().message(localizationUtils.getLocalizedMessage(MessageKeys.LOGIN_FAILED)).customer(customer).build());
            }catch (Exception e){
                return ResponseEntity.badRequest().body(RegisterResponse.builder().message(localizationUtils.getLocalizedMessage(MessageKeys.REGISTER_FAILED)).build());

            }


    }

    @PostMapping("/login")
        public ResponseEntity<LoginResponse> login(@RequestBody @Valid CustomerLoginDTO customerLoginDTO, BindingResult result) {
            try {
                String token = customerService.login(
                        customerLoginDTO.getEmail(),
                        customerLoginDTO.getPassword());
                return ResponseEntity.ok(LoginResponse.builder().message(localizationUtils.getLocalizedMessage(MessageKeys.LOGIN_SUCCESSFULLY)).token(token).build());
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(LoginResponse.builder().message(localizationUtils.getLocalizedMessage(MessageKeys.LOGIN_FAILED,e.getMessage())).build());
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

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable int id) {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }
    @PutMapping("/profile/{id}")
    public ResponseEntity<UpdateProfileResponse> updateProfile(@PathVariable int id, @RequestBody CustomerDTO customerDTO) {
        customerService.updateProfile(id, customerDTO);
        return ResponseEntity.ok(UpdateProfileResponse.builder().message(localizationUtils.getLocalizedMessage(MessageKeys.UPDATEPROFILE_SUCCESSFULLY)).build());
    }
    @PutMapping("/change-password/{id}")
    public ResponseEntity<?> changePassword(@PathVariable int id, @RequestBody ChangePasswordDTO changePasswordDTO) {
        try {
            customerService.changePassword(id, changePasswordDTO); // Gọi phương thức changePassword trong dịch vụ
            return ResponseEntity.ok(ChangPasswordResponse.builder().message(localizationUtils.getLocalizedMessage(MessageKeys.CHANGEPASSWORD_SUCCESSFULLY)).build());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Đã xảy ra lỗi");
        }
    }
    @PostMapping("/forgotPassword")
    public ResponseEntity<?> forgotPassword(@RequestBody ForgotPasswordDTO forgotPasswordDTO) {
        try {
            customerService.forgotPassword(forgotPasswordDTO);
            return ResponseEntity.ok(ForgotpasswordResponse.builder().message(localizationUtils.getLocalizedMessage(MessageKeys.FORGOTPASSWORD_SUCCESSFULLY)).build());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping("/resetPassword")
    public ResponseEntity<?> resetPassword(@RequestBody ResetPasswordDTO resetPasswordDTO) {
        try {
            customerService.resetPassword(resetPasswordDTO);
        return ResponseEntity.ok(ResetpasswordResponse.builder().message(localizationUtils.getLocalizedMessage(MessageKeys.RESETPASSWORD_SUCCESSFULLY)).build());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    //Show all categories
    @GetMapping("")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UpdateCustomerResponse> updateCustomer(@PathVariable int id, @RequestBody CustomerDTO customerDTO) {
        customerService.updateCustomer(id,customerDTO);
        return ResponseEntity.ok(UpdateCustomerResponse.builder().message(localizationUtils.getLocalizedMessage(MessageKeys.UPDATECUSTOMER_SUCCESSFULLY)).build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<DeleteCustomerResponse> deleteCustomer(@PathVariable int id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.ok(DeleteCustomerResponse.builder().message(localizationUtils.getLocalizedMessage(MessageKeys.DELETECUSTOMER_SUCCESSFULLY)).build());
    }
    @PutMapping("/status/{id}")
    public ResponseEntity<UpdateStatusResponse> updateStatusCustomer(@PathVariable int id, @RequestBody CustomerDTO customerDTO) {
        customerService.updateStatusCustomer(customerDTO, id);
        return ResponseEntity.ok(UpdateStatusResponse.builder().message(localizationUtils.getLocalizedMessage(MessageKeys.UPDATESTATUS_SUCCESSFULLY)).build());
    }

}

package com.egustore.eshop.response;

import com.egustore.eshop.enums.CustomerStatus;
import com.egustore.eshop.model.Customer;
import com.egustore.eshop.model.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerResponse {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

//    @JsonProperty("date_of_birth")
//    private Date dateOfBirth;

    @JsonProperty("email")
    private String email;

    @JsonProperty("phone_number")
    private String phoneNumber;

    @JsonProperty("facebook_id")
    private String facebookId;

    @JsonProperty("google_id")
    private String googleId;

    @JsonProperty("role_id")
    private Role role;

    public static CustomerResponse fromCustomer(Customer customer) {
        return CustomerResponse.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
//                .dateOfBirth(customer.getDateOfBirth())
                .email(customer.getEmail())
                .phoneNumber(customer.getPhoneNumber())
                .facebookId(customer.getFacebookId())
                .googleId(customer.getGoogleId())
                .role(customer.getRole())
                .build();
    }
}

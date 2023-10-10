package com.egustore.eshop.model;

import com.egustore.eshop.enums.CustomerStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "date_of_birth")
    private LocalDateTime date_of_birth;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phone_number;

    @Column(name = "password")
    private String password;

    @Column(name = "create_date")
    private LocalDateTime create_date;

    @Column(name = "facebook_id")
    private String facebook_id;

    @Column(name = "google_id")
    private String google_id;

    @Column(name = "reset_password_token")
    private String reset_password_token;


    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private CustomerStatus customerstatus;

//    @Column(name = "role_id")
//    private Integer role_id;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}

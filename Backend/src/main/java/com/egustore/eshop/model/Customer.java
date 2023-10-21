package com.egustore.eshop.model;

import com.egustore.eshop.enums.CustomerStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "password")
    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createDate")
    private LocalDateTime createDate;

//    @Column(name = "create_date")
//    private Date createDate;

    @Column(name = "facebook_id")
    private String facebookId;

    @Column(name = "google_id")
    private String googleId;

    @Column(name = "reset_password_token")
    private String resetPasswordToken;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private CustomerStatus customerStatus;

//    @Column(name = "role_id")
//    private Integer role_id;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role roleId;

}

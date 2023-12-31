package com.egustore.eshop.model;

import com.egustore.eshop.enums.CustomerStatus;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "customers")
public class Customer implements UserDetails {
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

    @Column(name = "create_date")
    private Date createDate;

    @PrePersist
    protected void onCreate(){
        Date now = new Date();
        createDate = now;
    }

    @Column(name = "facebook_id")
    private String facebookId;

    @Column(name = "google_id")
    private String googleId;

    @Column(name = "reset_password_token")
    private String resetPasswordToken;


    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private CustomerStatus status;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @Column(name = "role_id", insertable=false, updatable=false)
    private Integer roleId;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
//        authorityList.add(new SimpleGrantedAuthority("ROLE_" + getRole().getName().toUpperCase()));
        authorityList.add(new SimpleGrantedAuthority("ROLE_ADMIN") );
        authorityList.add(new SimpleGrantedAuthority("ROLE_CUSTOMER") );
        return authorityList;
    }
    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
package com.egustore.eshop.model;


import com.egustore.eshop.enums.CustomerStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CustomerReport {
    @Id
    private String name;

    private Double revenue;

    @Temporal(TemporalType.DATE)
    private Date birth_date;

    private String email;

    private String phone;

    @Temporal(TemporalType.DATE)
    private Date day_created;

    @Enumerated(EnumType.STRING)
    private CustomerStatus status;
}

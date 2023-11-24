package com.egustore.eshop.dto;

import com.egustore.eshop.enums.CustomerStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
public class CustomerReportDTO {
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

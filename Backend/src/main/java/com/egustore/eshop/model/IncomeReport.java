package com.egustore.eshop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class IncomeReport {
    @Id
    @Temporal(TemporalType.DATE)
    private Date date;
    private Long orders;

    private Double revenue;
}

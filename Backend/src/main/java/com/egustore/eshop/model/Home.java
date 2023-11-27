package com.egustore.eshop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Home {
    @Id
    private Long id;
    private String thumbnail;
    private String Name;
    private Double Price;
    private Double Discount;
    private double rate;
    private long count;
}

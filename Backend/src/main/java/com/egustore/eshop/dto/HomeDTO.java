package com.egustore.eshop.dto;

import jakarta.persistence.Id;
import lombok.Data;

@Data
public class HomeDTO {
    @Id
    private Long id;
    private String thumbnail;
    private String Model;
    private Double Price;
    private Double Discount;
    private double rate;
    private long count;
}

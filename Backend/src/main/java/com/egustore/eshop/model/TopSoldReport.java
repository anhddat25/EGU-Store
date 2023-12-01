package com.egustore.eshop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TopSoldReport {
    @Id
    private int id;

    private int totalPrice;

    private String name;

    private String model;

    private String thumbnail;

    private int quantity;
}

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
public class CategoryReport {
    @Id
    private int id;

    private int totalPrice;

    private String name;

    private int quantity;
}

package com.egustore.eshop.model;

import com.egustore.eshop.enums.ProductStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="products")
public class Product {
    @Id
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "model")
    private String model;

    @Column(name = "price")
    private double price;

    @Column(name = "stock_quantity")
    private int stock_quantity;

    @Column(name = "create_date")
    private Date create_date;

    @Column(name = "update_date")
    private Date update_date;

    @Column(name = "description")
    private String description;

    @Column(name = "discount")
    private double discount_percentage;

    @Column(name = "discount_price")
    private String discount_price;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private ProductStatus status;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}

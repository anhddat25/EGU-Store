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
@Table(name="product")
public class Product {
    @Id
    private int id;

    @Column(name = "name")
    private String Name;

    @Column(name = "Model")
    private String Model;

    @Column(name = "price")
    private double Price;

    @Column(name = "stock_quantity")
    private int stock_quantity;

    @Column(name = "create_date")
    private Date Create_date;

    @Column(name = "update_date")
    private Date Update_date;

    @Column(name = "Description")
    private String Description;

    @Column(name = "Discount")
    private double Discount;

    @Column(name = "discount_price")
    private String Discount_price;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private ProductStatus productStatus;

}

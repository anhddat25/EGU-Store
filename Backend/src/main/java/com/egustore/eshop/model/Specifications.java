package com.egustore.eshop.model;

import com.egustore.eshop.model.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "specifications")
public class Specifications {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "processor")
    private String processor;

    @Column(name = "graphicsCard")
    private String graphicsCard;

    @Column(name = "ram")
    private String ram;

    @Column(name = "storage")
    private String storage;

    @Column(name = "display")
    private String display;

    @Column(name = "operatingSystem")
    private String operatingSystem;

    @Column(name = "camera")
    private String camera;

//    @Column(name = "product_id")
//    private int product_id;
}

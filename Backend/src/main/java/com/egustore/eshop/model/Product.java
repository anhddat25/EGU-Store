package com.egustore.eshop.model;

import com.egustore.eshop.enums.ProductStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name="product")
public class Product extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "model")
    private String model;

    @Column(name = "price")
    private Double price;

    @Column(name = "stock_quantity")
    private Integer stockQuantity;

    @Column(name = "description")
    private String description;

    @Column(name = "discount_percentage")
    private Double discountPercentage;

    @Column(name = "discount_price")
    private String discountPrice;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private ProductStatus status;


    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "origin_id")
    private Origin origin;



    @Column(name = "origin_id", insertable=false, updatable=false)
    private Integer originId;

    @Column(name = "brand_id",  insertable=false, updatable=false)
    private Integer brandId;

    @Column(name = "category_id", insertable=false, updatable=false)
    private Integer categoryId;
}

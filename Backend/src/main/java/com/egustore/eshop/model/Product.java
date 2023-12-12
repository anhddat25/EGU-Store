package com.egustore.eshop.model;

import com.egustore.eshop.enums.ProductStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name="products")
public class Product extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "model")
    private String model;

    @Column(name = "price")
    private Double price;

    @Column(name = "thumbnail")
    private String thumbnail;

//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "create_date")
//    private LocalDateTime createDate;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "update_date")
//    private LocalDateTime updateDate;

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
    private Brand brandId;

    @ManyToOne
    @JoinColumn(name = "origin_id")
    private Origin originId;

    @JsonIgnoreProperties("products")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "products")
    private List<RatingProduct> ratingProduct;


    @JsonIgnoreProperties("products")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "products")
    private List<Images> images;

//    @Column(name = "origin_id", insertable=false, updatable=false)
//    private Integer originId;
//
//    @Column(name = "brand_id",  insertable=false, updatable=false)
//    private Integer brandId;
//
//    @Column(name = "category_id", insertable=false, updatable=false)
//    private Integer categoryId;
}

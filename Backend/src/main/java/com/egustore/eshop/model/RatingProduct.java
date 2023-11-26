package com.egustore.eshop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rating_products")
public class RatingProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name_customer")
    private String nameCustomer;

    @Column(name = "Rating")
    private int rating;

//    @Temporal(TemporalType.DATE)
    @Column(name = "create_date")
    private Date createDate;

//    @Temporal(TemporalType.DATE)
    @Column(name = "update_date")
    private Date updateDate;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customerId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product productId;
}

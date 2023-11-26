package com.egustore.eshop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "feedback_products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name_customer")
    private String nameCustomer;

    @Column(name = "comment")
    private String comment;

    @Column(name = "status")
    private String status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_date")
    private LocalDateTime updateDate;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customers;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product products;

    @Column(name = "customer_id", insertable=false, updatable=false)
    private Integer customerId;

    @Column(name = "product_id",  insertable=false, updatable=false)
    private Integer productId;


}
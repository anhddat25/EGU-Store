package com.egustore.eshop.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "feedbackProducts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name_user")
    private String nameCustomer;

    @Column(name = "comment")
    private String comment;

    @Column(name = "status")
    private String status;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "update_date")
    private Date updateDate;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
//    @JsonIgnoreProperties("feedbackProducts")
    @JoinColumn(name = "product_id")
    private Product products;

//    @Column(name = "product_id", insertable=false, updatable=false)
//    private Integer productId;

}
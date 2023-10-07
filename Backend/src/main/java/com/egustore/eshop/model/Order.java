package com.egustore.eshop.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(name = "Email")
    private String Email;
    @Column(name = "Phone")
    private String Phone;
    @Temporal(TemporalType.DATE)
    @Column(name = "order_date")
    private Date orderDate = new Date();
    @Column(name = "Note")
    private String Note;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status Status;
    @Column(name = "payment_method")
    private String paymentMethod;
    @Column(name = "discount_price")
    private Double discountPrice;
    @Column(name = "user_id")
    private int userId;
    @OneToMany(mappedBy = "order_id")
    private List<OrderDetail> orderDetail;
}

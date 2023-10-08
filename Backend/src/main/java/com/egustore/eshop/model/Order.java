package com.egustore.eshop.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Email")
    private String email;
    @Column(name = "Phone")
    private String phone;
    @Temporal(TemporalType.DATE)
    @Column(name = "order_date")
    private Date orderDate = new Date();
    @Column(name = "Note")
    private String note;
//    @Enumerated(EnumType.STRING)
//    @Column(name = "status")
//    private com.egustore.eshop.enums.Status status;
    @Column(name = "payment_method")
    private String paymentMethod;
    @Column(name = "discount_price")
    private Double discountPrice;
    @Column(name = "customer_id")
    private int customerId;
    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetail;
}
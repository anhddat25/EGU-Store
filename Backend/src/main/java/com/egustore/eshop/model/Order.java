package com.egustore.eshop.model;

import com.egustore.eshop.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Temporal(TemporalType.DATE)
    @Column(name = "order_date")
    private Date orderDate = new Date();

    @Column(name = "note")
    private String note;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "discount_price")
    private Double discountPrice;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "customer_id", insertable=false, updatable=false)
    private Integer customerId;

    @ManyToOne
    @JsonIgnoreProperties("order")
    @JoinColumn(name = "order_details_id")
    private OrderDetail orderdetail;


    @Column(name = "order_details_id", insertable=false, updatable=false)
    private Integer orderdetailId;

    @ManyToOne
    @JsonIgnoreProperties("order")
    @JoinColumn(name = "address_id")
    private Address address;


    @Column(name = "address_id", insertable=false, updatable=false)
    private Integer addressId;
//    @OneToMany(mappedBy = "order")
//    private List<OrderDetail> orderDetail;
}

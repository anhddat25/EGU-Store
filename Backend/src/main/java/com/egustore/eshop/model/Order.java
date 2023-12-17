package com.egustore.eshop.model;

import com.egustore.eshop.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
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
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "order_date")
    private LocalDateTime orderDate;

    @Column(name = "note")
    private String note;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Column(name = "address")
    private String address;

    @Column(name = "district")
    private String district;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "total_price")
    private Double totalPrice;

    @Column(name = "is_active")
    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name = "customer_id",insertable=false, updatable=false)
    private Customer customer;

    @Column(name = "customer_id")
    private Integer customerId;

    @PrePersist
    protected void onCreate(){
        LocalDateTime now = LocalDateTime.now();
        orderDate = now;
    }

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<OrderDetail> orderDetails;

}
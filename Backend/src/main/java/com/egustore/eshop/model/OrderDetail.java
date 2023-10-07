package com.egustore.eshop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(name = "Quantity")
    private int quantity;
    @Column(name = "total_price")
    private Double totalPrice;
    @Column(name = "order_id")
    private int orderId;
    @Column(name = "product_id")
    private int productId;
    @ManyToOne @JoinColumn(name = "order_id")
    private Order order;

//    @JsonIgnore
//    @ManyToOne @JoinColumn(name = "username")
//    private Account account;
//    @JsonIgnore
//    @OneToMany(mappedBy = "order")
//    private List<OrderDetail> orderDetail;
}

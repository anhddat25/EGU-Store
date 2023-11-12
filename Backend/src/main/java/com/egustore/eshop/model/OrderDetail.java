package com.egustore.eshop.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orderdetails")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Quantity")
    private int quantity;

    @Column(name = "total_price")
    private Double totalPrice;

    @ManyToOne
    @JsonIgnoreProperties("orderdetail")
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name ="product_id", insertable = false, updatable = false)
    private Integer productId;
    @Column(name ="order_id", insertable = false, updatable = false)
    private Integer orderId;

}

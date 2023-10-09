package com.egustore.eshop.model;

import jakarta.persistence.*;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Order_Details")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Quantity")
    private int quantity;
    @Column(name = "total_price")
    private Double totalPrice;
    @Column(name = "order_id", insertable=false, updatable=false)
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

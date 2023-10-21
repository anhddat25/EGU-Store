package com.egustore.eshop.dto;


import com.egustore.eshop.model.Order;
import com.egustore.eshop.model.Product;
import lombok.Data;

@Data
public class OrderDetailDTO {
    private Integer id;

    private Integer quantity;

    private Double totalPrice;

    private Order orderId;

    private Product productId;
}

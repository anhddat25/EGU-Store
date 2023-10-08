package com.egustore.eshop.dto;

import com.egustore.eshop.model.Order;
import lombok.*;


@Data
public class OrderDetailDTO {
    private int Id;
    private int quantity;
    private Double totalPrice;
    private int orderId;
    private int productId;
    private Order order;

}

package com.egustore.eshop.dto;

import lombok.*;


@Data
public class OrderDetailDTO {
    private int Id;
    private int quantity;
    private Double totalPrice;
    private int orderId;
    private int productId;
}

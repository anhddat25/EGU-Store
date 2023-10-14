package com.egustore.eshop.dto;

import com.egustore.eshop.model.Order;
import com.egustore.eshop.model.OrderDetail;
import com.egustore.eshop.model.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;


@Data
public class OrderDetailDTO {
    private Integer id;

    private Integer quantity;

    private Double totalPrice;

    @JsonProperty("product_id")
    private Integer productId;

    private Product product;

    @JsonProperty("order_id")
    private String orderId;

    private Order order;



}

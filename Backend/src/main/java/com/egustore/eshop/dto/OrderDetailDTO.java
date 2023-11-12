package com.egustore.eshop.dto;

import com.egustore.eshop.model.Order;
import com.egustore.eshop.model.OrderDetail;
import com.egustore.eshop.model.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class OrderDetailDTO {

    public Integer id;

    private Integer quantity;

    private Double totalPrice;

    @JsonProperty("product_id")
    private Integer productId;

    private Product product;

    @JsonProperty("order_id")
    private Integer orderId;

    private Order order;



    private Integer quantity;

    private Double totalPrice;

    private Order orderId;

    private Product productId;
}

package com.egustore.eshop.dto;

import com.egustore.eshop.enums.OrderStatus;
import com.egustore.eshop.model.Customer;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Data
public class OrderDTO {
    private Integer id;

    private String name;

    private String email;

    private String phone;

    private String address;

    private String district;

    private String city;

    private String country;

    private String note;

    private OrderStatus status;

    @JsonProperty("order_date")
    private LocalDateTime orderDate;

    @JsonProperty("payment_method")
    private String paymentMethod;

    @JsonProperty("total_price")
    private Double totalPrice;

    @JsonProperty("customer_id")
    private Integer customerId;

    @JsonProperty("cart_items")
    private List<CartItemDTO> cartItems;


}

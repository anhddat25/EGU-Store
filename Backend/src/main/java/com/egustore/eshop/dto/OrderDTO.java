package com.egustore.eshop.dto;

import com.egustore.eshop.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;


@Data
public class OrderDTO {
    private Integer id;

    private String email;

    private String phone;

    private  Date orderDate;

    private String note;

    private OrderStatus status;

    private String paymentMethod;

    private Double discountPrice;

    @JsonProperty("customer_id")
    private Integer customerId;

    private CustomerDTO customer;
}

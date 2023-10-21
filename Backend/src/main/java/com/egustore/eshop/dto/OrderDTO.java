package com.egustore.eshop.dto;

import com.egustore.eshop.enums.CustomerStatus;
import com.egustore.eshop.enums.OrderStatus;
import com.egustore.eshop.model.Customer;
import com.egustore.eshop.model.Role;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderDTO {
    private Integer id;

    private String email;

    private String phone;

    private LocalDateTime orderDate;

    private String note;

    private String paymentMethod;

    private Double discountPrice;

    private OrderStatus orderStatus;

    private Customer customerId;
}

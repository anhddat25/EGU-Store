package com.egustore.eshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private int orderId;
    private String orderEmail;
    private String orderPhone;
    private Date orderDate = new Date();
    private String orderNote;
    private String orderStatus;
    private String orderPaymentMethod;
    private Double orderDiscountPrice;
    private int orderCustomerId;
}

package com.egustore.eshop.dto;

import com.egustore.eshop.enums.Status;
import lombok.Data;

import java.util.Date;


@Data
public class OrderDTO {
    private int id;
    private String email;
    private String phone;
    private Date orderDate = new Date();
    private String note;
    private Status status;
    private String paymentMethod;
    private Double discountPrice;
    private int customerId;
}

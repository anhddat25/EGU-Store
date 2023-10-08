package com.egustore.eshop.dto;

import com.egustore.eshop.enums.Status;
import com.egustore.eshop.model.OrderDetail;
import lombok.*;

import java.util.Date;
import java.util.List;


@Data
public class OrderDTO {
    private int id;
    private String email;
    private String phone;
    private Date orderDate = new Date();
    private String note;
//    private Status orderStatus;
    private String paymentMethod;
    private Double discountPrice;
    private int customerId;
}

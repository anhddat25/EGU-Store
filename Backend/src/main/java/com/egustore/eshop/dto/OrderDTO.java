package com.egustore.eshop.dto;

import com.egustore.eshop.model.Status;
import jakarta.persistence.*;

import java.util.Date;

public class OrderDTO {
    private int Id;
    private String Email;
    private String Phone;
    private Date orderDate = new Date();
    private String Note;
    private com.egustore.eshop.model.Status Status;
    private String paymentMethod;
    private Double discountPrice;
    private int userId;
}

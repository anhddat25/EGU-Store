package com.egustore.eshop.dto;

import com.egustore.eshop.model.Customer;
import com.egustore.eshop.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackProductDTO {
    private int id;

    private String nameCustomer;

    private String comment;

    private String status;

    private Date createDate;

    private Date updateDate;

    private Customer customerId;

    private Product productId;

}

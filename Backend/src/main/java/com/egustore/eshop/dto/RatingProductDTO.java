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
public class RatingProductDTO {

    private Integer id;

    private String nameCustomer;

    private int rating;

    private Date createDate;

    private Date updateDate;

    private Customer customerId;
    private Product productId;
}

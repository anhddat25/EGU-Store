package com.egustore.eshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RatingProductDTO {
    private int id;
    private String nameCustomer;
    private int rating;
    private Date createDate;
    private Date updateDate;
//    private int customerId;
//    private int productId;
}

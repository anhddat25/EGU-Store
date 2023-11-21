package com.egustore.eshop.dto;

import com.egustore.eshop.model.Customer;
import com.egustore.eshop.model.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
@Data
public class FeedbackProductDTO {
    private Integer id;

    private String nameCustomer;

    private String comment;

    private String status;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;

//    @JsonProperty("customer_id")
//    private Integer customerId;
//
//    @JsonProperty("product_id")
//    private Integer productId;

    private Product products;

    private Customer customers;
}

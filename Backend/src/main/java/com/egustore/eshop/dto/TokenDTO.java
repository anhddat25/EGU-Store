package com.egustore.eshop.dto;

import com.egustore.eshop.enums.ImageStatus;
import com.egustore.eshop.model.Customer;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class TokenDTO {
    private Integer id;

    private String title;

    private String imageUrl;

    private LocalDateTime expDate;

    private Customer customerId;
}

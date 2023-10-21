package com.egustore.eshop.dto;

import com.egustore.eshop.enums.CustomerStatus;
import com.egustore.eshop.enums.ProductStatus;
import com.egustore.eshop.model.Brand;
import com.egustore.eshop.model.Category;
import com.egustore.eshop.model.Origins;
import com.egustore.eshop.model.Role;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class ProductDTO {

    private Integer id;

    private String name;

    private Integer stockQuantity;

    private String model;

    private Double price;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;

    private String description;

    private Double discountPrice;

    private Double discount;

    private ProductStatus productStatus;

    private Category categoryId;

    private Brand brandId;

    private Origins originsId;
}

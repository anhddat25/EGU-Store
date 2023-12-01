package com.egustore.eshop.dto;

import com.egustore.eshop.enums.ProductStatus;
import com.egustore.eshop.model.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Column;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
public class ProductDTO {
    private Integer id;

    private String name;

    private String model;

    private Double price;

    private String thumbImage;

    private Integer stockQuantity;

    private String description;

    private Double discountPercentage;

    private String discountPrice;

    @Enumerated(EnumType.STRING)
    private ProductStatus status;

    @JsonProperty("category_id")
//    private Integer categoryId;

    private Category categoryId;

    @JsonProperty("brand_id")
//    private Integer brandId;

    private Brand brandId;

    @JsonProperty("origin_id")
//    private Integer originId;

    private Origin originId;


}

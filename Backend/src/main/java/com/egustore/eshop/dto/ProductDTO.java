package com.egustore.eshop.dto;

import com.egustore.eshop.enums.ProductStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import java.sql.Date;
import java.time.LocalDateTime;

@Data
public class ProductDTO {
    private Integer id;

    private String name;

    private String model;

    private Double price;

    private Integer stockQuantity;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;

    private String description;

    private Double discountPercentage;

    private String discountPrice;

    @Enumerated(EnumType.STRING)
    private ProductStatus status;

    @JsonProperty("category_id")
    private Integer category_id;

    private CategoryDTO category;

    @JsonProperty("brand_id")
    private Integer brand_id;

    @JsonProperty("origins_id")
    private Integer origins_id;

    private BrandDTO brand;


    private OriginDTO origins;



}

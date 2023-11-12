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
    private Integer categoryId;

    @JsonProperty("brand_id")
    private Integer brandId;

    @JsonProperty("origin_id")
    private Integer originId;



    private CategoryDTO category;



    private BrandDTO brand;


    private OriginDTO origin;




}

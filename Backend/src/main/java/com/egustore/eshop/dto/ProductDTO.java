package com.egustore.eshop.dto;

import com.egustore.eshop.enums.ProductStatus;
import com.egustore.eshop.model.Images;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import com.egustore.eshop.model.BaseEntity;
import jakarta.persistence.Column;

import lombok.Data;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class ProductDTO {
    private Integer id;

    private String name;

    private String model;

    private Double price;

    private String thumbImage;

    private Integer stockQuantity;

    private Date createDate;

    private Date updateDate;

    private String description;

    private Double discountPercentage;

    private String discountPrice;

    @Enumerated(EnumType.STRING)
    private ProductStatus status;

    @JsonProperty("category_id")
    private Integer categoryId;

    private CategoryDTO category;

    @JsonProperty("brand_id")
    private Integer brandId;

    private BrandDTO brand;

    @JsonProperty("origin_id")
    private Integer originId;

    private OriginDTO origin;

}

package com.egustore.eshop.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    private String status;

    @JsonProperty("category_id")
    private Integer categoryId;

    @JsonProperty("brand_id")
    private Integer brandId;

    @JsonProperty("origin_id")
    private Integer originId;

    private BrandDTO brand;

    private CategoryDTO category;

    private OriginDTO origin;


}

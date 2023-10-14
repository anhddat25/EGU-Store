package com.egustore.eshop.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.sql.Date;

@Data
public class ProductDTO {
    private int id;

    private String name;

    private String model;

    private Double price;

    private Integer stockQuantity;

    private Date createDate;

    private Date updateDate;

    private String description;

    private Double discountPercentage;

    private String discountPrice;

    private String status;

    @JsonProperty("category_id")
    private Integer categoryId;

    private CategoryDTO category;

}

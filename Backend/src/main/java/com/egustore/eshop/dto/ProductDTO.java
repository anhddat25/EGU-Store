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

    private Integer stock_quantity;

    private Date create_date;

    private Date update_date;

    private String description;

    private Double discount_percentage;

    private String discount_price;

    private String status;

    @JsonProperty("category_id")
    private String categoryId;

    private CategoryDTO category;

}

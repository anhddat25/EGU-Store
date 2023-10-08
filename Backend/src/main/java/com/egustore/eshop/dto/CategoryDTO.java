package com.egustore.eshop.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
public class CategoryDTO {
    public Integer categoryId;

    public String categoryName;

//    public String description;

//    private String status;

//    public String title;

}

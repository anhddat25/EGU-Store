package com.egustore.eshop.dto;

import com.egustore.eshop.enums.CategoryStatus;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
public class CategoryDTO {
    private Integer id;

    private String name;

    private String description;

//    private CategoryStatus status;


}

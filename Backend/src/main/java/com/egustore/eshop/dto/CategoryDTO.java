package com.egustore.eshop.dto;

import com.egustore.eshop.enums.CategoryStatus;
import com.egustore.eshop.model.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Data

public class CategoryDTO  {
    private Integer id;

    private String name;

    private CategoryStatus status;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;

}

package com.egustore.eshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryReportDTO {

    private int id;

    private int totalPrice;

    private String name;

    private int quantity;
}

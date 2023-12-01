package com.egustore.eshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TopSoldReportDTO {

    private int id;

    private int totalPrice;

    private String name;

    private String model;

    private String thumbnail;

    private int quantity;
}

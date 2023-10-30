package com.egustore.eshop.dto;

import lombok.Data;

import java.util.Date;



@Data
public class IncomeReportDTO {

    private Date date;
    private Long orders;
    private Double revenue;
}

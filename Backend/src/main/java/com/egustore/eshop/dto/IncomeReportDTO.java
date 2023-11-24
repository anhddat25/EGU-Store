package com.egustore.eshop.dto;

import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

import java.util.Date;



@Data
public class IncomeReportDTO {

    private Date date;
    private Long orders;
    private Double revenue;
}

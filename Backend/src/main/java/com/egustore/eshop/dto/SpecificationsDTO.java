package com.egustore.eshop.dto;

import jakarta.persistence.Column;
import lombok.*;

@Data
public class SpecificationsDTO {
    private Integer id;
    private String processor;
    private String graphicsCard;
    private String ram;
    private String storage;
    private String display;
    private String operatingSystem;
    private String camera;
//    private Integer product_id;
}

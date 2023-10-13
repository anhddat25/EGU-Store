package com.egustore.eshop.dto;

import lombok.Data;
import java.sql.Date;

@Data
public class ProductDTO {
    private int id;

    private String Name;

    private String Model;

    private double Price;

    private int stock_quantity;

    private Date Create_date;

    private Date Update_date;

    private String Description;

    private double Discount;

    private String Discount_price;
}

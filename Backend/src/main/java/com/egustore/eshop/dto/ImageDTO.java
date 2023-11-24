package com.egustore.eshop.dto;

import com.egustore.eshop.enums.ImageStatus;
import com.egustore.eshop.model.Product;
import lombok.Data;

import java.util.Date;

@Data
public class ImageDTO {

    private Integer id;

    private String title;

    private String imageUrl;

    private Date createDate;

    private Date updateDate;

    private Product products;

    private ImageStatus imageStatus;
}

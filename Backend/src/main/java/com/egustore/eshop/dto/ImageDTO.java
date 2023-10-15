package com.egustore.eshop.dto;

import com.egustore.eshop.enums.ImageStatus;
import lombok.Data;

import java.util.Date;

@Data
public class ImageDTO {

    private Integer id;

    private String title;

    private String image_url;

    private Date create_date;

    private Date update_date;

    private Integer product_id;

    private ImageStatus imageStatus;
}

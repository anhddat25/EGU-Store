package com.egustore.eshop.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PaymentDTO {
    private Integer version;
    private String command;
    private Double amount;
    private String bankCode;
    private Date createDate;
    private String currentCode;
    private String ipAddress;
    private String locale;
    private String orderInfo;
    private String orderType;
    private String returnUrl;
    private String txt_ref;
    private String secureHash;
}

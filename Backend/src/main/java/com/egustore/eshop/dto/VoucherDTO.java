package com.egustore.eshop.dto;

import com.egustore.eshop.enums.VoucherStatus;
import lombok.Data;

import java.util.Date;

@Data
public class VoucherDTO {
    private String codeVoucher;
    private Double value;
    private VoucherStatus status;
    private Date expiredDate;
    private Integer customerId;
}

package com.egustore.eshop.model;


import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "payments")
public class Payment {
    @Id
    private Integer version;

    @Column(name = "command")
    private String command;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "bank_code")
    private String bankCode;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "current_code")
    private String currentCode;

    @Column(name = "ip_address")
    private String ipAddress;

    @Column(name = "locale")
    private String locale;

    @Column(name = "order_info")
    private String orderInfo;

    @Column(name = "order_type")
    private String orderType;

    @Column(name = "return_url")
    private String returnUrl;

    @Column(name = "txt_ref")
    private String txtRef;

    @Column(name = "secure_hash")
    private String secureHash;
}

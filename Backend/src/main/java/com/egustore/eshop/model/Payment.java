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

    @Column(name = "bankCode")
    private String bankCode;

    @Column(name = "createDate")
    private Date createDate;

    @Column(name = "currentCode")
    private String currentCode;

    @Column(name = "ipAddress")
    private String ipAddress;

    @Column(name = "locale")
    private String locale;

    @Column(name = "orderInfo")
    private String orderInfo;

    @Column(name = "orderType")
    private String orderType;

    @Column(name = "returnUrl")
    private String returnUrl;

    @Column(name = "txt_ref")
    private String txt_ref;

    @Column(name = "secureHash")
    private String secureHash;
}

package com.egustore.eshop.model;

import com.egustore.eshop.enums.VoucherStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="vouchers")
@Entity
public class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="code_voucher")
    private String codeVoucher;
    @Column(name="value")
    private Double value;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private VoucherStatus status;
    @Column(name="expired_date")
    private Date expiredDate;
    @Column(name="customer_id")
    private int customerId;
    public boolean isActive() {
        return this.getStatus() == VoucherStatus.ACTIVE;
    }
}

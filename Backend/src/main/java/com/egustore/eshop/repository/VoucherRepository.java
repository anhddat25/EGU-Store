package com.egustore.eshop.repository;

import com.egustore.eshop.enums.VoucherStatus;
import com.egustore.eshop.model.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface VoucherRepository extends JpaRepository<Voucher, Integer> {
    List<Voucher> findAllByExpiredDateBeforeAndStatusNot(Date expiredDate, VoucherStatus status);
    List<Voucher> findByCustomerId( int customerId);
    Optional<Voucher> findByCodeVoucher(String codeVoucher);
}

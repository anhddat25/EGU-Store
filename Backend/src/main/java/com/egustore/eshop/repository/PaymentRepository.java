package com.egustore.eshop.repository;

import com.egustore.eshop.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO payments (version, command, amount, bank_code, create_date, current_code, ip_address, locale, order_info, order_type, return_url, txn_ref, secure_hash) " +
            "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)", nativeQuery = true)
    void insertPayment(String version, String command, double amount, String bankCode, String createDate, String currentCode,
                       String ipAddress, String locale,String orderInfo, String orderType, String returnUrl, String txnRef,
                       String secureHash);
}

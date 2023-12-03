package com.egustore.eshop.service;

import com.egustore.eshop.dto.PaymentDTO;
import com.egustore.eshop.model.Payment;

import java.io.UnsupportedEncodingException;
import java.util.List;

public interface PaymentService {
    String createPayment(String vnp_Version, String vnp_Command, String orderType, long amountP, String bankCode, String vnp_IpAddr) throws UnsupportedEncodingException;
    Payment getPaymentByVer(int version);
    Payment updatePayment(int version, PaymentDTO payment);
    List<Payment> getAllPayment();
    void deletePayment(int version);

}
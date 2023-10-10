package com.egustore.eshop.service;

import com.egustore.eshop.dto.PaymentDTO;
import com.egustore.eshop.model.Payment;

import java.util.List;

public interface PaymentService {
    Payment createPayment(PaymentDTO paymentDTO);
    Payment getPaymentByVer(int version);
    Payment updatePayment(int version, PaymentDTO payment);
    List<Payment> getAllPayment();
    void deletePayment(int version);

}

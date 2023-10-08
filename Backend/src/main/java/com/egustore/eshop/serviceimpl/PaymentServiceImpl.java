package com.egustore.eshop.serviceimpl;

import com.egustore.eshop.entity.Payment;
import com.egustore.eshop.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public class PaymentServiceImpl {
//    @Autowired
//    private PaymentRepository paymentRepository;
//
//    @Override
//    public List<Payment> getAllPayments() {
//        return paymentRepository.findAll();
//    }
//
//    @Override
//    public Payment getPaymentById(Long id) {
//        return paymentRepository.findById(id).orElse(null);
//    }
//
//    @Override
//    public Payment createPayment(Payment payment) {
//        return paymentRepository.save(payment);
//    }
//
//    @Override
//    public void deletePayment(Long id) {
//        paymentRepository.deleteById(id);
//    }
//
//    @Override
//    public Page<Payment> getAllPaymentsByPage(Pageable pageable) {
//        return paymentRepository.findAll(pageable);
//    }
//
//    @Override
//    public Page<Payment> getAllPaymentsByStatus(String status, Pageable pageable) {
//        return paymentRepository.findByStatus(status, pageable);
//    }
//
//    @Override
//    public Page<Payment> getAllPaymentsByAmount(Double amount, Pageable pageable) {
//        return paymentRepository.findByAmount(amount, pageable);
//    }
//
//    @Override
//    public Page<Payment> getAllPaymentsByDate(Date date, Pageable pageable) {
//        return paymentRepository.findByCreateDate(date, pageable);
//    }
}

package com.egustore.eshop.serviceimpl;

import com.egustore.eshop.dto.PaymentDTO;
import com.egustore.eshop.mapper.PaymentMapper;
import com.egustore.eshop.model.Payment;
import com.egustore.eshop.repository.PaymentRepository;
import com.egustore.eshop.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;

    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository, PaymentMapper paymentMapper)
    {
        this.paymentRepository = paymentRepository;
        this.paymentMapper = paymentMapper;
    }

    @Override
    public Payment createPayment(PaymentDTO paymentDTO) {
        Payment payment = paymentMapper.mapToPayment(paymentDTO);
        return paymentRepository.save(payment);
    }

    @Override
    public Payment getPaymentByVer(int version){
        return paymentRepository.findById(version)
                .orElseThrow(() -> new RuntimeException("Payment not found"));
    }

    @Override
    public Payment updatePayment(int version, PaymentDTO paymentDTO) {
        Payment existPayment = getPaymentByVer(version);
        paymentMapper.updatePaymentFromDTO(paymentDTO, existPayment);
        paymentRepository.save(existPayment);
        return existPayment;
    }

    @Override
    public List<Payment> getAllPayment() {
        return paymentRepository.findAll();
    }

    @Override
    public void deletePayment(int version) {

        paymentRepository.deleteById(version);
    }
}

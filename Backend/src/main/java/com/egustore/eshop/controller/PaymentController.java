package com.egustore.eshop.controller;


import com.egustore.eshop.entity.Payment;
import com.egustore.eshop.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")

public class PaymentController {
    @Autowired
    private PaymentService paymentService;

//    @GetMapping
//    public List<Payment> getAllPayments() {
//        return (List<Payment>) paymentService.getAllPayments();
//    }
//
//    @GetMapping("/{id}")
//    public Payment getPaymentById(@PathVariable Long id) {
//        return paymentService.getPaymentById(id);
//    }
//
//    @PostMapping
//    public Payment createPayment(@RequestBody Payment payment) {
//        return paymentService.createPayment(payment);
//    }
//
//    @PutMapping("/{id}")
//    public Payment updatePayment(@PathVariable Long id, @RequestBody Payment payment) {
//        return paymentService.updatePayment(id, payment);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deletePayment(@PathVariable Long id) {
//        paymentService.deletePayment(id);
//    }

}

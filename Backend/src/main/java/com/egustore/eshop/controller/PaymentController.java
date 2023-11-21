package com.egustore.eshop.controller;


import com.egustore.eshop.dto.PaymentDTO;
import com.egustore.eshop.model.Payment;
import com.egustore.eshop.service.PaymentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v0/payment")
@Validated
@CrossOrigin("*")
public class PaymentController {
    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    //Create category
    @PostMapping("/create")
    public ResponseEntity<?> createPayment(@RequestBody @Valid PaymentDTO paymentDTO, BindingResult result)
    {
        if(result.hasErrors())
        {
            List<String> errMessage = result.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)
                    .toList();
            return ResponseEntity.badRequest().body(errMessage);
        }
        paymentService.createPayment(paymentDTO);
        return ResponseEntity.ok("Create payment successfully!");
    }

    //    //Show all categories
    @GetMapping("/list")
    public ResponseEntity<List<Payment>> getAllPayment() {
        List<Payment> payment = paymentService.getAllPayment();
        return ResponseEntity.ok(payment);
    }

    @PutMapping("/update/{version}")
    public ResponseEntity<String> updatePayment(@PathVariable int version,@RequestBody PaymentDTO paymentDTO) {
        paymentService.updatePayment(version,paymentDTO);
        return ResponseEntity.ok("update payment ");
    }

    @DeleteMapping("/delete/{version}")
    public ResponseEntity<String> deletePayment(@PathVariable int version) {
        paymentService.deletePayment(version);
        return ResponseEntity.ok("delete Payment " + version);

}}

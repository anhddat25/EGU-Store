package com.egustore.eshop.controller;


import com.egustore.eshop.config.ConfigPayment;
import com.egustore.eshop.dto.PaymentDTO;
import com.egustore.eshop.model.Payment;
import com.egustore.eshop.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;

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

    @RequestMapping("/create-payment")
    public String createPayment(
            @RequestParam long amount) throws UnsupportedEncodingException {
        String bankCode = "NCB";
        String vnp_Command = "pay";
        String orderType = "other";
        long amountP = amount * 100;
        String vnp_Version = "2.1.0";
        String vnp_IpAddr = "127.0.0.1";
        return paymentService.createPayment(vnp_Version, vnp_Command, orderType, amountP, bankCode, vnp_IpAddr);
    }
//    @PostMapping("")
//    public ResponseEntity<?> createPayment(@RequestBody @Valid PaymentDTO paymentDTO, BindingResult result)
//    {
//        if(result.hasErrors())
//        {
//            List<String> errMessage = result.getFieldErrors()
//                    .stream()
//                    .map(FieldError::getDefaultMessage)
//                    .toList();
//            return ResponseEntity.badRequest().body(errMessage);
//        }
//        paymentService.createPayment(paymentDTO);
//        return ResponseEntity.ok("Create payment successfully!");
//
//    }

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

package com.egustore.eshop.controller;


import com.egustore.eshop.dto.PaymentDTO;
import com.egustore.eshop.model.Payment;
import com.egustore.eshop.response.*;
import com.egustore.eshop.service.PaymentService;
import com.egustore.eshop.utils.LocalizationUtils;
import com.egustore.eshop.utils.MessageKeys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
@RequestMapping("/api/v0/payment")
@Validated
@CrossOrigin("*")
public class PaymentController {
    private final PaymentService paymentService;
    private final LocalizationUtils localizationUtils;

    @Autowired
    public PaymentController(PaymentService paymentService, LocalizationUtils localizationUtils) {
        this.paymentService = paymentService;
        this.localizationUtils = localizationUtils;
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

    //    //Show all categories
    @GetMapping("/list")
    public ResponseEntity<List<Payment>> getAllPayment() {
        List<Payment> payment = paymentService.getAllPayment();
        return ResponseEntity.ok(payment);
    }

    @PutMapping("/update/{version}")
    public ResponseEntity<UpdatePaymentResponse> updatePayment(@PathVariable int version,@RequestBody PaymentDTO paymentDTO) {
        try{
        paymentService.updatePayment(version,paymentDTO);
        return ResponseEntity.ok(UpdatePaymentResponse.builder().message(localizationUtils.getLocalizedMessage(MessageKeys.UPDATEPAYMENT_SUCCESSFULLY)).build());
        }catch (Exception e){
            return ResponseEntity.badRequest().body(UpdatePaymentResponse.builder().message(localizationUtils.getLocalizedMessage(MessageKeys.UPDATEPAYMENT_FAILED,e.getMessage())).build());
        }
    }

    @DeleteMapping("/delete/{version}")
    public ResponseEntity<DeletePaymentResponse> deletePayment(@PathVariable int version) {
        try{
        paymentService.deletePayment(version);
        return ResponseEntity.ok(DeletePaymentResponse.builder().message(localizationUtils.getLocalizedMessage(MessageKeys.DELETEPAYMENT_SUCCESSFULLY)).build());
        }catch (Exception e){
            return ResponseEntity.badRequest().body(DeletePaymentResponse.builder().message(localizationUtils.getLocalizedMessage(MessageKeys.DELETEPAYMENT_FAILED,e.getMessage())).build());
        }
    }
}

package com.egustore.eshop.controller;

import com.egustore.eshop.dto.SmsRequest;
import com.egustore.eshop.serviceimpl.SmsService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v0/sms")
public class SMSController {
    private final SmsService smsService;

    public SMSController(SmsService smsService) {
        this.smsService = smsService;
    }


    @PostMapping
    public void sendSms(@Valid @RequestBody SmsRequest smsRequest){
        smsService.sendSms(smsRequest);
    }
}

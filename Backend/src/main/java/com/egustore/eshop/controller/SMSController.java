package com.egustore.eshop.controller;

import com.egustore.eshop.dto.SmsDTO;
import com.egustore.eshop.serviceimpl.SmsSender;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v0/sms")
public class SMSController {
    private final SmsSender smsSender;

    public SMSController(SmsSender smsSender) {
        this.smsSender = smsSender;
    }


    @PostMapping
    public void sendSms(@Valid @RequestBody SmsDTO smsDTO){
        smsSender.sendSms(smsDTO);
    }
}

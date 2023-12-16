package com.egustore.eshop.serviceimpl;

import com.egustore.eshop.dto.SmsDTO;
import org.springframework.beans.factory.annotation.Qualifier;

@org.springframework.stereotype.Service
public class SmsSender {
    private final com.egustore.eshop.service.SmsService smsService;

    public SmsSender(@Qualifier("twilio") SmsServiceImpl smsSender) {
        this.smsService = smsSender;
    }

    public void sendSms(SmsDTO smsDTO){
        smsService.sendSms(smsDTO);
    }
}

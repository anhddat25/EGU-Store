package com.egustore.eshop.serviceimpl;

import com.egustore.eshop.dto.SmsRequest;
import com.egustore.eshop.service.SmsSender;
import org.springframework.beans.factory.annotation.Qualifier;

@org.springframework.stereotype.Service
public class SmsService {
    private final SmsSender smsSender;

    public SmsService(@Qualifier("twilio") TwilioSmsSender smsSender) {
        this.smsSender = smsSender;
    }

    public void sendSms(SmsRequest smsRequest){
        smsSender.sendSms(smsRequest);
    }
}

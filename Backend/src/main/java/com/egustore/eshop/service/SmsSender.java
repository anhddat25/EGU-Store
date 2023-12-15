package com.egustore.eshop.service;

import com.egustore.eshop.dto.SmsRequest;

public interface SmsSender {
    void sendSms(SmsRequest smsRequest);
}

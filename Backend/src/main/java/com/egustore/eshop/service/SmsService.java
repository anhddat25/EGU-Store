package com.egustore.eshop.service;

import com.egustore.eshop.dto.SmsDTO;

public interface SmsService {
    void sendSms(SmsDTO smsDTO);
}

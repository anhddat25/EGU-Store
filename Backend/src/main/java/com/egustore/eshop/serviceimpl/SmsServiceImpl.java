package com.egustore.eshop.serviceimpl;

import com.egustore.eshop.config.TwilioConfiguration;
import com.egustore.eshop.dto.SmsDTO;
import com.egustore.eshop.service.SmsService;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("twilio")
public class SmsServiceImpl implements SmsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SmsServiceImpl.class);
    private final TwilioConfiguration twilioConfiguration;

    public SmsServiceImpl(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
    }

    @Override
    public void sendSms(SmsDTO smsDTO) {
        if(isPhoneNumberValid(smsDTO.getPhoneNumber())){
            PhoneNumber to = new PhoneNumber(smsDTO.getPhoneNumber());
            PhoneNumber from = new PhoneNumber(twilioConfiguration.getTrialNumber());

            String message = smsDTO.getMessage();
            MessageCreator creator = Message.creator(to,from,message);
            creator.create();
            LOGGER.info("Send sms []" + smsDTO);

        }else{
            throw new IllegalArgumentException("PhoneNumber [" + smsDTO.getPhoneNumber() + "] is not a valid number");
        }
    }

    private boolean isPhoneNumberValid(String phoneNumber){
        return true;
    }
}

package com.egustore.eshop.config;

import com.twilio.Twilio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TwilioInitiazer {
    private final static Logger LOGGER = LoggerFactory.getLogger(TwilioInitiazer.class);
    private final TwilioConfiguration twilioConfiguration;

    public TwilioInitiazer(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
        Twilio.init(
                twilioConfiguration.getAccountSid(),
                twilioConfiguration.getAuthToken()
        );
        LOGGER.info("Twilio initialized... with account sid {}", twilioConfiguration.getAccountSid());
    }
}

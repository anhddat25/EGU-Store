package com.egustore.eshop.service;

public interface EmailService {
    void sendEmail(String to, String subject, String body);
}
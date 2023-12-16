package com.egustore.eshop.serviceimpl;

import com.egustore.eshop.service.EmailService;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender emailSender;

    public EmailServiceImpl(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    @Override
    public void sendEmail(String to, String subject, String body) throws MailException {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to);
            message.setSubject(subject);
            message.setText(body);
            message.setFrom("edgu1707@gmail.com"); // Thay đổi địa chỉ người gửi thành một địa chỉ cụ thể
            emailSender.send(message);
        } catch (MailException e) {
            throw e; // Ném lại ngoại lệ để báo hiệu rằng việc gửi email thất bại
        }
    }
}

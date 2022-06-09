package com.esoa.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
//import org.springframework.mail.javamail.JavaMailSender;
@Service
public class EmailService {

    //private final JavaMailSender sender;
    //AÑADIR DEPENDENCIA MAIL EN POM.XML
    /*
    @Value("${spring.mail.username}")
    private String from;

    private static final String SUBJECT = "Welcome email";
    private static final String TEXT = "Welcome to our page. Thank you for registering!";

    @Async
    public void send(String to) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setFrom(from);
        message.setSubject(SUBJECT);
        message.setText(TEXT);
        sender.send(message);
    }
    */
}

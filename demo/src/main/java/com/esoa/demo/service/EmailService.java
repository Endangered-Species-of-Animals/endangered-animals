package com.esoa.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender sender;

    @Value("endangered.species.of.animals@gmail.com")
    private String from;

    private static final String SUBJECT = "Welcome email";
    private static final String TEXT = "Welcome to our page. Thank you for registering!";
    private static final String COMMENT = "Thank you for contacting us. We will read your comments soon.";
    
    @Async
    public void send(String to) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setFrom(from);
        message.setSubject(SUBJECT);
        message.setText(TEXT);
        sender.send(message);
    }

    @Async
    public void sendGreateful(String to) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setFrom(from);
        message.setSubject(SUBJECT);
        message.setText(COMMENT);
        sender.send(message);
    }

}

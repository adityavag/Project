package com.adt.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    JavaMailSender javaMailSender;

    public void sendEmail(String email, String username) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("adi247u@gmail.com");
        message.setTo(email);
        message.setText("Dear " + username + ", \nWelcome Aboard !\nWe're delighted to have you join us.");
        message.setSubject("Welcome To Resume Builder !");
        javaMailSender.send(message);
    }
}

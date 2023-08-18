package com.example.mailsender.Controllers;

import com.example.mailsender.DTO.MailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailSenderService {
    @Autowired
    private JavaMailSender mailSender;

    @PostMapping("/signup")
    public String sendEmail(@RequestBody MailRequest form){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(".com");
        message.setSubject("Message from " + form.getName());
        double randomNum = Math.random() * 100000;
        message.setText("This is your verification code: " + randomNum);

        mailSender.send(message);

        return "Email sent successfully";
    }

//    @GetMapping("/send-email")
//    public String sendEmail2(@RequestBody MailRequest form){
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo("davidodewusi@gmail.com");
//        message.setSubject("Message from " + form.getName());
//        message.setText(form.getBody() + "\n\nFrom: " + form.getEmail());
//
//        mailSender.send(message);
//
//        return "Email sent successfully";
//    }
}

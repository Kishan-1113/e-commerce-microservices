package com.example.e_commerce_microservices.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.e_commerce_microservices.Services.EmailService;

@RestController
@RequestMapping("/email")
public class MailServiceController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/health")
    public String health() {
        return new String("Hello, how are you? I am fine !");
    }

    @PostMapping("/send")
    public String sendMail(@RequestBody String to) {
        emailService.sendSimpleEmail(
                to,
                "Test Email",
                "Hello, your email is working successfully!");
        return "Email sent!";
    }
}

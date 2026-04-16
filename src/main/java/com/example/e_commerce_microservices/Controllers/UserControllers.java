package com.example.e_commerce_microservices.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/users")
public class UserControllers {

    @GetMapping("/test")
    public String testMethod() {
        return new String("Testing functioning !");
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String param) {
        return param;
    }

    @PostMapping("/old")
    public void redirect(HttpServletRequest request, HttpServletResponse response, @RequestBody String s)
            throws IOException, ServletException {

        // Store the body in an attribute so the next method can find it without
        // re-reading the stream
        request.setAttribute("sharedBody", s);

        request.getRequestDispatcher("/users/new").forward(request, response);
    }

    @PostMapping("/new")
    public String registerUser(HttpServletRequest request, @RequestBody(required = false) String s) {
        // If 's' is null because the stream was consumed, check the attribute
        String body = (s != null) ? s : (String) request.getAttribute("sharedBody");
        return "Hello in new forwarded endpoint! Data: " + body;
    }

}

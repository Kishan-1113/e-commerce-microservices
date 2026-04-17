package com.example.e_commerce_microservices.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.e_commerce_microservices.Models.LoginRequest;
import com.example.e_commerce_microservices.Models.ModelUser;
import com.example.e_commerce_microservices.Services.UserServices;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/users")
public class UserControllers {

    @Autowired
    private UserServices userServices;

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest entity) {
        return userServices.loginUser(entity) != null
                ? ResponseEntity.status(HttpStatus.OK).body(userServices.loginUser(entity))
                : ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody ModelUser user) {
        userServices.registerUser(user);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
    }

    // This old endpoint redirects to new endpoint
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

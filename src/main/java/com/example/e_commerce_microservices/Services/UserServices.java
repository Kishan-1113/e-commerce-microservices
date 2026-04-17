package com.example.e_commerce_microservices.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators.Mod;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.e_commerce_microservices.Exceptions.ResourceNotFoundException;
import com.example.e_commerce_microservices.Models.LoginRequest;
import com.example.e_commerce_microservices.Models.ModelUser;
import com.example.e_commerce_microservices.Repos.JpaRepo4Users;

@Service
public class UserServices {

    @Autowired
    private JpaRepo4Users userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authManager;

    public List<ModelUser> getAllUsers() {
        return userRepo.findAll();
    }

    public void registerUser(ModelUser user) {
        if (user != null) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepo.save(user);
        } else
            throw new ResourceNotFoundException("User can't be empty !");
    }

    public ModelUser loginUser(LoginRequest entity) {

        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        entity.getEmail(),
                        entity.getPassword()));

        return userRepo.findUserByemail(entity.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    public void addToCart(String productId) {

    }

}

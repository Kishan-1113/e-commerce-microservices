package com.example.e_commerce_microservices.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.e_commerce_microservices.Exceptions.ResourceNotFoundException;
import com.example.e_commerce_microservices.Models.LoginRequest;
import com.example.e_commerce_microservices.Models.ModelUser;
import com.example.e_commerce_microservices.Repos.JpaRepo4Users;

@Service
public class UserServices {

    @Autowired
    private JpaRepo4Users userRepo;

    public void registerUser(ModelUser user) {
        if (user != null)
            userRepo.save(user);
    }

    public boolean loginUser(LoginRequest entity) {
        ModelUser user = userRepo.findUserByemail(entity.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("User not found !"));
        return user.getPassword().equals(entity.getPassword());
    }

    public void addToCart(String productId) {

    }

}

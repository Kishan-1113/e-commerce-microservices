package com.example.e_commerce_microservices.Services;

import java.util.List;

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

    public List<ModelUser> getAllUsers() {
        return userRepo.findAll();
    }

    public void registerUser(ModelUser user) {
        if (user != null)
            userRepo.save(user);
        else
            throw new ResourceNotFoundException("User can't be empty !");
    }

    public boolean loginUser(LoginRequest entity) {
        ModelUser user = userRepo.findUserByemail(entity.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("User not found !"));
        return user.getPassword().equals(entity.getPassword());
    }

    public void addToCart(String productId) {

    }

}

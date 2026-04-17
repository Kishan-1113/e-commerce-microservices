package com.example.e_commerce_microservices.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.e_commerce_microservices.Exceptions.ResourceNotFoundException;
import com.example.e_commerce_microservices.Models.ModelUser;
import com.example.e_commerce_microservices.Models.UserPrinciple;
import com.example.e_commerce_microservices.Repos.JpaRepo4Users;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private JpaRepo4Users userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        ModelUser user = userRepo.findUserByemail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found !"));

        return new UserPrinciple(user);
    }

}

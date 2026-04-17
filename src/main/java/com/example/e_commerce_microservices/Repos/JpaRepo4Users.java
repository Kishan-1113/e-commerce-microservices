package com.example.e_commerce_microservices.Repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.e_commerce_microservices.Models.ModelUser;

@Repository
public interface JpaRepo4Users extends JpaRepository<ModelUser, Integer> {

    Optional<ModelUser> findUserByemail(String username);

}

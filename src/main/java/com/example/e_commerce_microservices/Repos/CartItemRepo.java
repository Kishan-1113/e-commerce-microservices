package com.example.e_commerce_microservices.Repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.e_commerce_microservices.Models.CartItemModel;

@Repository
public interface CartItemRepo extends JpaRepository<CartItemModel, Long> {

    Optional<CartItemModel> findByUserIdAndProductId(Long userId, String productId);

    List<CartItemModel> findByUserId(Long userId);
}

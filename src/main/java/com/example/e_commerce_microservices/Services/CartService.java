package com.example.e_commerce_microservices.Services;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.e_commerce_microservices.Exceptions.ResourceNotFoundException;
import com.example.e_commerce_microservices.Models.CartItemModel;
import com.example.e_commerce_microservices.Models.ProductModel;
import com.example.e_commerce_microservices.Repos.CartItemRepo;
import com.example.e_commerce_microservices.Repos.MongoRepo4Products;

@Service
public class CartService {

    @Autowired
    private CartItemRepo cartItemRepo;

    @Autowired
    private MongoRepo4Products productRepo;

    public void addToCart(Long userId, String productId, int quantity) {

        // Validating product exists in MongoDB
        Optional<ProductModel> productOpt = productRepo.findById(new ObjectId(productId));

        ProductModel product = productOpt.orElseThrow(() -> new ResourceNotFoundException("Product not found !"));

        // If item already exists in cart
        Optional<CartItemModel> existingItem = cartItemRepo.findByUserIdAndProductId(userId, productId);

        if (existingItem.isPresent()) {
            // Update quantity only
            CartItemModel item = existingItem.get();
            item.setQuantity(item.getQuantity() + quantity);
            cartItemRepo.save(item);
        } else {
            // Create new cart item
            CartItemModel newItem = new CartItemModel();
            newItem.setUserId(userId);
            newItem.setProductId(productId);
            newItem.setQuantity(quantity);

            cartItemRepo.save(newItem);
        }
    }

}

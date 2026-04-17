package com.example.e_commerce_microservices.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.e_commerce_microservices.Exceptions.ResourceNotFoundException;
import com.example.e_commerce_microservices.Models.ProductModel;
import com.example.e_commerce_microservices.Models.UpdatePriceRequest;
import com.example.e_commerce_microservices.Repos.MongoRepo4Products;

@Service
public class ProductServices {

    @Autowired
    private MongoRepo4Products mongoRepo;

    public ProductModel getProduct(String name) {
        return mongoRepo.findProductByname(name).orElseThrow(() -> new ResourceNotFoundException("No such Product !"));
    }

    public List<ProductModel> getAllProducts() {
        return mongoRepo.findAll();
    }

    public ProductModel addProduct(ProductModel product) {
        if (product != null)
            mongoRepo.save(product);
        return product;
    }

    public ProductModel updatePrice(String name, UpdatePriceRequest request) {
        ProductModel product = mongoRepo.findProductByname(name)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        product.setPrice(request.getPrice());

        return mongoRepo.save(product);
    }

}

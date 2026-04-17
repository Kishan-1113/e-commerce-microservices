package com.example.e_commerce_microservices.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.e_commerce_microservices.Models.ProductModel;
import com.example.e_commerce_microservices.Repos.MongoRepo4Products;

@Service
public class ProductServices {

    @Autowired
    private MongoRepo4Products mongoRepo;

    public List<ProductModel> getProducts() {
        return mongoRepo.findAll();
    }

    public ProductModel addProduct(ProductModel product) {
        if (product != null)
            mongoRepo.save(product);
        return product;
    }

}

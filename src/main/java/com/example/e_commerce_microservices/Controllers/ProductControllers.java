package com.example.e_commerce_microservices.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.e_commerce_microservices.Models.ProductModel;
import com.example.e_commerce_microservices.Services.ProductServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/products")
public class ProductControllers {

    @Autowired
    private ProductServices productServices;

    @GetMapping("/all")
    public ResponseEntity<List<ProductModel>> getAllProducts() {
        return ResponseEntity.status(HttpStatus.FOUND).body(productServices.getProducts());
    }

    @PostMapping("/new")
    public ResponseEntity<ProductModel> addNewProduct(@RequestBody ProductModel product) {

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(productServices.addProduct(product));
    }

}

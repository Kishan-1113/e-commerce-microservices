package com.example.e_commerce_microservices.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.e_commerce_microservices.Models.ProductModel;
import com.example.e_commerce_microservices.Models.UpdatePriceRequest;
import com.example.e_commerce_microservices.Services.ProductServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/products")
public class ProductControllers {

    @Autowired
    private ProductServices productServices;

    @GetMapping("/{name}")
    public ProductModel getProduct(@PathVariable String name) {
        return productServices.getProduct(name);
    }
}

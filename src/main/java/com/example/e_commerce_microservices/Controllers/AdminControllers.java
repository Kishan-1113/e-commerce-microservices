package com.example.e_commerce_microservices.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.e_commerce_microservices.Models.ModelUser;
import com.example.e_commerce_microservices.Models.ProductModel;
import com.example.e_commerce_microservices.Models.UpdatePriceRequest;
import com.example.e_commerce_microservices.Services.ProductServices;
import com.example.e_commerce_microservices.Services.UserServices;

import org.springframework.web.bind.annotation.RequestParam;

@RestController
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping("/admin")
public class AdminControllers {

    @Autowired
    private ProductServices productServices;

    @Autowired
    private UserServices userServices;

    // Admin level product controllers
    @GetMapping("/products/all")
    public ResponseEntity<List<ProductModel>> getAllProducts() {
        return ResponseEntity.status(HttpStatus.FOUND).body(productServices.getAllProducts());
    }

    @PostMapping("/products/new")
    public ResponseEntity<ProductModel> addNewProduct(@RequestBody ProductModel product) {

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(productServices.addProduct(product));
    }

    @PutMapping("/products/updatePrice/{name}")
    public ResponseEntity<?> putMethodName(@PathVariable String name, @RequestBody UpdatePriceRequest entity) {
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    // Admin level User Controllers

    @GetMapping("/users/all")
    public ResponseEntity<List<ModelUser>> getAllUsers() {
        System.out.println("\n\n reached /admin/users/all");
        return ResponseEntity.status(HttpStatus.OK).body(userServices.getAllUsers());
    }

}

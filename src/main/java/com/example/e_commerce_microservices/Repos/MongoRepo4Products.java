package com.example.e_commerce_microservices.Repos;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.e_commerce_microservices.Models.ProductModel;

@Repository
public interface MongoRepo4Products extends MongoRepository<ProductModel, ObjectId> {

    Optional<ProductModel> findProductByname(String productname);

}
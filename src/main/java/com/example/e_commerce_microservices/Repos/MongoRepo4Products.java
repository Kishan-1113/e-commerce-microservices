package com.example.e_commerce_microservices.Repos;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.e_commerce_microservices.Models.ProductModel;

public interface MongoRepo4Products extends MongoRepository<ProductModel, ObjectId> {

}
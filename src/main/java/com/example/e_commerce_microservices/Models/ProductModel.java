package com.example.e_commerce_microservices.Models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "Products")
public class ProductModel {

    @Id
    private ObjectId Id;

    @NonNull
    @Indexed(unique = true)
    private String name;
    private String description;
    @NonNull
    private double price;

}

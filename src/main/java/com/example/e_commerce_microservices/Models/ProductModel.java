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
    private ObjectId id;

    @NonNull
    @Indexed(unique = true)
    private String name;
    private String description;
    @NonNull
    private double price;
    @NonNull
    private boolean active = true;
    @NonNull
    private String category;

    private long quantity;
    private String imgUrl = "https://img.freepik.com/premium-vector/ecommerce-brand-logo-vector-graphic_1152716-1392.jpg?semt=ais_hybrid&w=740&q=80";

}

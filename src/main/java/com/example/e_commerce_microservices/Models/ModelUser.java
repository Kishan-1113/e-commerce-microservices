package com.example.e_commerce_microservices.Models;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModelUser {
    private long id;
    private String name;
    private String email;
    private List<String> userCart;
    private List<String> addresses;

}

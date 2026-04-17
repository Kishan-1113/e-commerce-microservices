package com.example.e_commerce_microservices.Models;

import java.util.List;

import com.mongodb.lang.NonNull;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "customers", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
public class ModelUser {

    @Id
    private long id;

    @NonNull
    private String name;
    @NonNull
    private String email;
    @NonNull
    private String password;

    // Fetch the
    private List<String> userCart;
    private List<String> addresses;

}

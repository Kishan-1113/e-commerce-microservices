package com.example.e_commerce_microservices.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mongodb.MongoWriteException;

@RestControllerAdvice
public class GlobalExceptionHandle {

    @ExceptionHandler(MongoWriteException.class)
    public ResponseEntity<String> handleDuplicate(MongoWriteException ex) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body("Product with this name already exists");
    }

}

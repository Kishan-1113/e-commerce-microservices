package com.example.e_commerce_microservices.Exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mongodb.MongoWriteException;

@RestControllerAdvice
public class GlobalExceptionHandle {

    // For mongodb
    @ExceptionHandler(MongoWriteException.class)
    public ResponseEntity<String> handleDuplicate(MongoWriteException ex) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body("Product with this name already exists");
    }

    // For postgres
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDuplicateEmail(DataIntegrityViolationException ex) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body("Email already exists, try a new one !");
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleNotFound(ResourceNotFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }

}

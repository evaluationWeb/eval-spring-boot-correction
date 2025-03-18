package com.adrar.evalspring.controller;

import com.adrar.evalspring.exception.CategorieNotFoundException;
import com.adrar.evalspring.exception.NoCategorieFoundException;
import com.adrar.evalspring.exception.NoProductFoundException;
import com.adrar.evalspring.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(NoCategorieFoundException.class)
    public ResponseEntity<Map<String, String>> handleNoCategorieFoundException(NoCategorieFoundException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("error", ex.getMessage());
        return ResponseEntity
                .status(org.springframework.http.HttpStatus.NOT_FOUND)
                .body(response);
    }

    @ExceptionHandler(NoProductFoundException.class)
    public ResponseEntity<Map<String, String>> handleNoProductFoundException(NoProductFoundException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("error", ex.getMessage());
        return ResponseEntity
                .status(org.springframework.http.HttpStatus.NOT_FOUND)
                .body(response);
    }

    @ExceptionHandler(CategorieNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleCategorieNotFoundException(CategorieNotFoundException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("error", ex.getMessage());
        return ResponseEntity
                .status(org.springframework.http.HttpStatus.NOT_FOUND)
                .body(response);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleProductNotFoundException(ProductNotFoundException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("error", ex.getMessage());
        return ResponseEntity
                .status(org.springframework.http.HttpStatus.NOT_FOUND)
                .body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(error -> errors.put(
                        error.getField(),
                        error.getDefaultMessage())
                );
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errors);
    }
}

package com.example.phoneservice.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(BrandNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleCategoryNotFound(BrandNotFoundException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("status", 404);
        body.put("message", ex.getMessage());
        body.put("error", "Not Found");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> handleBadRequest(IllegalArgumentException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("status", 400);
        body.put("message", ex.getMessage());
        body.put("error", "Bad Request");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }
}


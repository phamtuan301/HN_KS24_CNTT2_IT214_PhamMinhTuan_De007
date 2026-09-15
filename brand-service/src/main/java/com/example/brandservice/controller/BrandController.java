package com.example.brandservice.controller;

import com.example.brandservice.service.BrandService;
import com.example.brandservice.entity.Brand;
import com.example.brandservice.exception.ResourceNotFoundException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/brands")
public class BrandController {
    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Brand> getBrandById(@PathVariable Long id) {
        Brand brand = brandService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Brand không tồn tại"));
        return ResponseEntity.ok(brand);
    }
}

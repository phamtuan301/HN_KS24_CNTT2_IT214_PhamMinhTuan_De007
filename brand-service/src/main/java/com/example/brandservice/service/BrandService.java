package com.example.brandservice.service;
import com.example.brandservice.entity.Brand;
import java.util.Optional;

public interface BrandService {
    Optional<Brand> findById(Long id);
}


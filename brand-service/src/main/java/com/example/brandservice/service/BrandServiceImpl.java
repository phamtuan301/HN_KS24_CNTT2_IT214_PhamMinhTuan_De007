package com.example.brandservice.service;
import com.example.brandservice.entity.Brand;
import com.example.brandservice.repository.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public Optional<Brand> findById(Long id) {
        return brandRepository.findById(id);
    }
}


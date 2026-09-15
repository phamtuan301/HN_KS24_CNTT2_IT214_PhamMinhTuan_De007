package com.example.phoneservice.client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

@FeignClient(name = "brand-service")
public interface BrandClient {
    @GetMapping("/api/brands/{id}")
    ResponseEntity<Map<String, Object>> getBrandById(@PathVariable("id") Long id);
}


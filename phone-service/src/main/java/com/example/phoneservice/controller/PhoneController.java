package com.example.phoneservice.controller;
import com.example.phoneservice.dto.PhoneRequest;
import com.example.phoneservice.entity.Phone;
import com.example.phoneservice.service.PhoneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/phones")
public class PhoneController {
    private final PhoneService phoneService;
    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @GetMapping
    public List<Phone> getAll() {
        return phoneService.getAll();
    }

    @PostMapping
    public ResponseEntity<Phone> createPhone(@RequestBody PhoneRequest request) {
        Phone phone = phoneService.createPhone(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(phone);
    }
}


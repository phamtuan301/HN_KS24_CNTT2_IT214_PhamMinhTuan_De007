package com.example.phoneservice.service;

import com.example.phoneservice.dto.PhoneRequest;
import com.example.phoneservice.entity.Phone;

import java.util.List;

public interface PhoneService {
    List<Phone> getAll();
    Phone createPhone(PhoneRequest request);
}


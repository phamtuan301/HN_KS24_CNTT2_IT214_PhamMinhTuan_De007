package com.example.phoneservice.service;
import com.example.phoneservice.client.BrandClient;
import com.example.phoneservice.dto.PhoneRequest;
import com.example.phoneservice.entity.Phone;
import com.example.phoneservice.exception.BrandNotFoundException;
import com.example.phoneservice.repository.PhoneRepository;
import feign.FeignException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PhoneServiceImpl implements PhoneService {
    private final PhoneRepository phoneRepository;
    private final BrandClient brandClient;

    public PhoneServiceImpl(PhoneRepository phoneRepository, BrandClient brandClient) {
        this.phoneRepository = phoneRepository;
        this.brandClient = brandClient;
    }

    @Override
    public List<Phone> getAll() {
        return phoneRepository.findAll();
    }

    @Override
    public Phone createPhone(PhoneRequest request) {
        if (request == null || request.getBrandId() == null || request.getName() == null || request.getName().isBlank()) {
            throw new IllegalArgumentException("Tên điện thoại và brandId không được để trống");
        }

        try {
            ResponseEntity<Map<String, Object>> response = brandClient.getBrandById(request.getBrandId());
            if (!response.getStatusCode().is2xxSuccessful()) {
                throw new BrandNotFoundException("Brand không tồn tại");
            }
        } catch (FeignException.NotFound e) {
            throw new BrandNotFoundException("Brand không tồn tại");
        } catch (FeignException e) {
            throw new IllegalStateException("Không thể kết nối tới brand-service", e);
        }

        Phone phone = new Phone(request.getName(), request.getBrandId());
        return phoneRepository.save(phone);
    }
}


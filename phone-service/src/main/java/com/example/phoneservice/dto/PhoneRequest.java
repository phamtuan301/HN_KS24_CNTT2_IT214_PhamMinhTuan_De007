package com.example.phoneservice.dto;

public class PhoneRequest {
    private String name;
    private Long brandId;

    public PhoneRequest() {
    }

    public PhoneRequest(String name, Long brandId) {
        this.name = name;
        this.brandId = brandId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }
}


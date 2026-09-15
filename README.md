# Microservice Hackathon Project

## Cách chạy hệ thống theo thứ tự

1. Chạy `config-server`
2. Chạy `eureka-server`
3. Chạy `brand-service`
4. Chạy `phone-service`
5. Chạy `api-gateway`

## API kiểm thử qua cổng 8080

### Brand
- `GET http://localhost:8080/api/brands/{id}`

### Phone
- `GET http://localhost:8080/api/phones`
- `POST http://localhost:8080/api/phones`


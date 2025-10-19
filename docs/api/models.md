# Models and DTOs

## DTOs

### `LoginRequestDto`
```json
{
  "username": "string",
  "password": "string"
}
```

### `LoginResponseDto`
```json
{
  "token": "string",
  "expiration": 0
}
```
- `expiration`: milliseconds until token expiry.

### `UserRegistrationDto`
```json
{
  "firstName": "string",
  "lastName": "string",
  "username": "string",
  "password": "string",
  "mobileNumber": "string",
  "email": "string"
}
```

### `OrderRegistrationDto`
```json
{
  "id": 0,
  "count": 0,
  "productId": 0
}
```

### `OrdersRegistered`
```json
{
  "orders": [
    { "id": 0, "count": 0, "productId": 0 }
  ]
}
```

## Domain Models

### `User`
- `id: Long`
- `firstName: String`
- `lastName: String`
- `username: String`
- `password: String`
- `email: String`
- `mobileNumber: String`

### `Order`
- `id: Long`
- `count: Long`
- `product: Product`
- `requset: Request`
- `createdAt: LocalDateTime`
- `updatedAt: LocalDateTime`

### `Product`
- `id: Long`
- `createdAt: LocalDateTime`
- `updatedAt: LocalDateTime`

### `Delivery`
- `id: Long`
- `createdAt: LocalDateTime`
- `updatedAt: LocalDateTime`

### `Request`
- `id: Long`
- `createdAt: LocalDateTime`
- `updatedAt: LocalDateTime`

## Service Models

### `UserRegistration`
- `firstName: String`
- `lastName: String`
- `username: String`
- `password: String`
- `mobileNumber: String`
- `email: String`

### `OrderRegistration`
- `id: Long`
- `count: Long`
- `productId: Long`
- `userId: Long`

# REST Endpoints

All endpoints are relative to the server base URL.

## Users

- POST `/users/login`
  - Body:
    ```json
    {
      "username": "alice",
      "password": "secret"
    }
    ```
  - Response 200:
    ```json
    {
      "token": "Bearer <jwt>",
      "expiration": 3600000
    }
    ```
  - Notes: Public, returns JWT prefixed with `Bearer `.

- POST `/users/register`
  - Body:
    ```json
    {
      "firstName": "Alice",
      "lastName": "Doe",
      "username": "alice",
      "password": "secret",
      "mobileNumber": "+12025550123",
      "email": "alice@example.com"
    }
    ```
  - Response: 200 OK
  - Notes: Public.

## Orders

- POST `/orders` (Authenticated)
  - Headers: `Authorization: Bearer <jwt>`
  - Body:
    ```json
    {
      "id": 1,
      "count": 2,
      "productId": 1001
    }
    ```
  - Response: 200 OK
  - Behavior: Creates or updates an order item; positive count adds, negative removes.

- DELETE `/orders/{id}` (Authenticated)
  - Headers: `Authorization: Bearer <jwt>`
  - Response: 200 OK

- GET `/orders` (Authenticated)
  - Headers: `Authorization: Bearer <jwt>`
  - Response 200:
    ```json
    {
      "orders": [
        { "id": 1, "count": 2, "productId": 1001 }
      ]
    }
    ```

## Products

- Base path reserved: `/products` (no public endpoints implemented yet)

## Delivery

- Base path reserved: `/delivery` (no public endpoints implemented yet)

## Payments

- Base path reserved: `/payments` (no public endpoints implemented yet)

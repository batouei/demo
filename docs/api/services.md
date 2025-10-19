# Service APIs

## `UserService`

```java
User findByUsername(String username)
void register(UserRegistration userRegistration)
```

- **findByUsername**: Look up a user by username.
- **register**: Persist a new user from `UserRegistration`.

## `OrderService`

```java
void createOrUpdateOrder(OrderRegistration orderRegistration)
void deleteOrder(String id, Long userId)
List<Order> findRegisterOrders(Long userId)
```

- **createOrUpdateOrder**: Add/update a user's order line.
- **deleteOrder**: Delete a specific order by id for a user.
- **findRegisterOrders**: List registered orders for a user.

## `ProductService`

No public methods defined yet.

## `DeliveryService`

No public methods defined yet.

## `RequestService`

No public methods defined yet.

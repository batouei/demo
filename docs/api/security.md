# Security and Authentication

This project uses stateless JWT-based authentication.

- **Public routes**: Configured via `security.allowedRoutes` properties. Typically includes `POST /users/login` and `POST /users/register`.
- **Protected routes**: All others require `Authorization: Bearer <jwt>` header.
- **Filter**: `JwtTokenFilter` extracts the `Bearer` token from the `Authorization` header and injects it into the security context.
- **Auth provider**: `JwtTokenAuthProvider` validates the JWT using `JwtUtil`, loads the user via `UserService`, and sets `AuthUser` as the authenticated principal.
- **Token format**: `JwtUtil` issues tokens prefixed with `Bearer `. Include only the raw JWT string in the header without the `Bearer ` prefix duplication.

## Example: Login and use token

1. `POST /users/login` with credentials to receive `token` and `expiration`.
2. For subsequent requests, set header:

```http
Authorization: Bearer <jwt>
```

## CORS

- Enabled for all origins, headers, and methods via a `CorsFilter` bean.

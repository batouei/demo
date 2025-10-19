# Errors and Responses

Global exception handling is provided by `GlobalExceptionHandler`.

- `UserNotFoundException` → 500 Internal Server Error with localized message body.
- `UnAuthorizedUserException` → 401 Unauthorized with localized message body.

Other authentication failures return 401 from the security entry point.

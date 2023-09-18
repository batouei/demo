# Shop Project README

## Project Overview

This project is a monolithic architecture-based e-commerce application designed with a multi-layer architecture. It leverages Spring Security for authentication with JWT (JSON Web Tokens) for secure user interactions. Additionally, Spring filters are utilized to inspect the authentication token header, and certain API endpoints such as login and registration are accessed through these filters.

The authentication process involves token verification, and upon successful validation, the authenticated user details are stored in the Spring context. Passwords are securely stored in the database using the Bcrypt encoder.

## Business Project Design

The core functionality of this project revolves around several key entities, including:

1. **User:** Represents the users of the application.
2. **Order:** Encompasses the process of users browsing products, adding or removing items from their cart, and creating orders. Each user action on orders is tracked with a Request object in the database.
3. **Product:** Represents the items available for purchase.
4. **Delivery:** Includes the available delivery times for orders.
5. **Payment:** Manages the payment process, including the generation of tracker IDs and interaction with an IPG (Internet Payment Gateway).
6. **Request:** Tracks user actions on orders, such as adding or removing products.

The typical user journey for making a purchase involves the following steps:

1. Users browse the product list.
2. They select desired products and initiate the ordering process using the POST Order API. Users can add or remove products during this process by specifying the product ID and count (positive/negative). Requests are created in the database to monitor user actions on orders.
3. Users can view a list of their orders, delete orders using the Delete Order API, or make changes to orders using the POST Order API.
4. Users select a delivery time from the available options.
5. The payment process begins, generating a tracker ID. The application interacts with an IPG, redirecting users to complete the payment process.
6. Upon completion, the tracker ID is obtained from the IPG, and the result (success/fail) is saved in the payment table.

## Database
- **Database:** The application utilizes a robust relational database, Oracle, which can be alternative by MySQL or other databases. Oracle can be set up using a Docker image and managed with Docker Compose.

## Exception Handling

The project includes a GlobalExceptionHandler class responsible for catching service exceptions and translating them into appropriate error messages with associated HTTP status codes. The approach involves using the name of the GlobalExceptionHandler and fetching the translated description from the message_faproperty.

## Testing

Testing is a crucial aspect of this project, ensuring the reliability and correctness of the application. The testing approach includes:

- **Unit Testing:** Controller classes are thoroughly unit tested, with dependencies being mocked to isolate the components.
- **Mockito Library:** Mockito is used for creating mock objects and simulating the behavior of dependencies.

## API Documentation

API documentation is provided in the form of a Swagger YAML file (swagger.yml). You can access the graphical Swagger documentation using IntelliJ IDEA or by visiting [https://editor.swagger.io/](https://editor.swagger.io/). This documentation serves as a valuable resource for understanding and interacting with the project's API endpoints.

## Project Architecture

The following diagram illustrates the relationships within the shop domain:

```
![image](https://github.com/batouei/demo/assets/52099498/1ba5b34c-03c1-45ff-9ec3-ca428c7553a9)

```

This README serves as an initial guide to understanding the structure and functionality of the shop project. For more detailed information and instructions, please refer to the relevant documentation and codebase.

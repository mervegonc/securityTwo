# Spring Security User Authentication

## Project Description

This project is a simple Spring Boot application that manages user signup and login processes securely. The main objective is to provide a secure mechanism for user registration and authentication. User information is stored encrypted, and Spring Security is utilized for the login process.

## Project Components

1. **AuthController**: A REST controller class that manages user signup and login operations.

2. **LoginRequest and SignupRequest Classes**: Request classes containing username and password fields.

3. **SecurityConfig**: Class where Spring Security is configured. Authentication and authorization settings are defined here.

4. **SSecurityApplication**: Entry point of the application. It initializes the Spring Boot application.

5. **User and UserDetailsServiceImpl Classes**: Classes representing user information. UserDetailsServiceImpl is a service class providing user details used by Spring Security.

6. **UserRepository**: JPA repository where user data is stored.

7. **WebConfig**: Class used for CORS (Cross-Origin Resource Sharing) configuration, allowing requests from different origins.

## Project Objective

The primary objective of this project is to provide a secure mechanism for user registration and authentication. By employing Spring Security and encryption techniques, the project ensures that user data remains protected during signup and login processes. Through the implementation of secure REST endpoints, users can securely register and access the application, contributing to the overall security posture of the system.

**Note**: The next step in this project will be the addition of JWT token authentication.

## Usage

The project provides "/signup" and "/login" endpoints. "/signup" endpoint is used for user registration, while "/login" endpoint is used for user login. Spring Security is employed to ensure the security of all requests.

For more detailed information on usage and development of the project, refer to the project documentation or relevant resources.

## Development Environment and Technologies

- The project is developed using Spring Boot and Spring Security.
- Spring Data JPA is used for database operations.
- BCryptPasswordEncoder is utilized for password encryption.

## Further Information

For more detailed information on usage and development of the project, refer to the project documentation or relevant resources.

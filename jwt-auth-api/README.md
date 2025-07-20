# JWT Auth API

A simple Spring Boot application demonstrating **JWT-based authentication** using Spring Security.
This project covers the fundamentals of secure login with token generation, protecting API endpoints using stateless session management.

## 💻 Technologies

- Java 24  
- Spring Boot 3.5.3  
- Spring Security  
- Spring Data JPA  
- H2 Database (in-memory)  
- JWT (via [JJWT](https://github.com/jwtk/jjwt))  
- Lombok  

## 🔐 Features

- Register a new user (`POST /auth/register`)
- Authenticate and receive a JWT (`POST /auth/login`)
- Protect endpoints with token validation
- Stateless session management
- Password encryption with BCrypt


## 📁 Project Structure
```
📦 jwt-auth-api
 └── src/main/java/com/github/douglashauschild/jwtauthapi
	├── controller # REST endpoints
	├── dto # Request and response models (record types)
	├── entity # Domain model (User, Role)
	├── repository # JPA repositories
	├── security # JWT logic and Spring Security config
	└── service # Business logic (AuthService)
```

## 🚀 Running the Project
You can run it with Maven:
```bash
./mvnw spring-boot:run
```
Or run the compiled jar:
```bash
./mvnw clean package
java -jar target/jwt-auth-api-0.0.1-SNAPSHOT.jar
```

## 🧪 Test the API with cURL

###  Register a new user
```bash
curl -X POST http://localhost:8080/auth/register \
  -H "Content-Type: application/json" \
  -d '{"username":"john", "password":"123456"}'
```
### Login and get JWT
```bash
curl -X POST http://localhost:8080/auth/login \
  -H "Content-Type: application/json" \
  -d '{"username":"john", "password":"123456"}'
```
Response:
```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9..."
}
```
### Access a protected route (if added)
```bash
curl -H "Authorization: Bearer <your_token>" http://localhost:8080/protected
```

## ⚙️ Configuration
Make sure to configure the JWT secret in ``application.properties``:
```bash
jwt.secret=8b720c44e8f249f9b6bb324ccd7368fa8b720c44e8f249f9b6bb324ccd7368fa
```
You can change the expiration time in ``JwtService.java``.

## 💡 Learning Purpose
This project is ideal for:
- Learning JWT authentication in Spring Boot
- Understanding UserDetailsService, filters and security config
- Building stateless APIs using Spring Security
- Getting started with real-world backend security

## 👨🏻‍💻 Author
Douglas Hauschild  
[LinkedIn](https://www.linkedin.com/in/douglas-hauschild-66449122b/) | [GitHub](https://github.com/douglashauschild)

# Hexagonal API

A sample Spring Boot application demonstrating **Hexagonal Architecture (Ports and Adapters)**.  
This project is designed to showcase how to build clean, testable, and maintainable Java applications by separating the core business logic from the infrastructure.

## 💻 Technologies

- Java 24
- Spring Boot 3.5.3
- Spring Web
- Spring Data JPA
- H2 Database (in-memory)
- Bean Validation (JSR-380)
- Lombok

## 📐 Hexagonal Architecture Overview

This project follows the principles of **Hexagonal Architecture**:

    ┌────────────────────┐
    │    Controllers     │  → Web Layer (Input Adapter)
    └────────┬───────────┘
             ↓
    ┌────────────────────┐
    │ Application Service│  → Orchestrates use cases
    └────────┬───────────┘
             ↓
    ┌────────────────────┐
    │   Domain Model     │  → Core business logic & rules
    └────────┬───────────┘
             ↓
    ┌────────────────────┐
    │ Persistence Adapter│  → JPA Repositories, DB
    └────────────────────┘

- **Input adapters:** REST controllers that receive HTTP requests.
- **Application layer:** Coordinates domain logic and external adapters.
- **Domain layer:** Pure business logic, entities, and ports (interfaces).
- **Output adapters:** Implement domain ports (e.g., database repositories).

## 📁 Project Structure

```
📦 hexagonal-api
 └── src/main/java/com/github/douglashauschild/hexagonalapi
		├── application # Application services (use cases)
		├── domain
		│ 		├── model # Domain entities
		│ 		└── repository # Domain ports (interfaces)
		├── infrastructure
		│ 		├── persistence # JPA repository implementations
		│ 		└── web # REST controllers (input adapters)
		└── config # Spring configuration classes
```

## 🚀 Running the Project
You can run it with Maven:
```bash
./mvnw spring-boot:run
```
Or run the compiled jar:
```bash
./mvnw clean package
java -jar target/hexagonal-api-0.0.1-SNAPSHOT.jar
```

## 🧪 Test the API with cURL

###  Create a Customer
```bash
curl -X POST http://localhost:8080/customer -H "Content-Type: application/json" -d '{"name":"Customer","email":"customer@email.com"}'
```
### Get a Client by ID
```bash
curl -X http://localhost:8080/customer/1'
```
### Get All Clients
```bash
curl -X http://localhost:8080/customer'
```
### Test Validation Error
```bash
curl -X POST http://localhost:8080/customer -H "Content-Type: application/json" -d '{"name":"Customer","email":"invalido"}'
```

## 🔎 H2 Console
You can access the H2 database console at:
```bash
http://localhost:8080/h2-console
```
Make sure this property is enabled in ``application.properties``:
```bash
spring.h2.console.enabled=true
spring.jpa.hibernate.ddl-auto=update
```
## 💡 Learning Purpose
This project is ideal for:
- Practicing clean architecture with Spring Boot
- Understanding separation of concerns
- Preparing for enterprise-grade Java application design

## 👨🏻‍💻 Author
Douglas Hauschild  
[LinkedIn](https://www.linkedin.com/in/douglas-hauschild-66449122b/) | [GitHub](https://github.com/douglashauschild)
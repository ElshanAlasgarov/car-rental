# 🚗 Car Rental System (Spring Boot)

This project is a **Car Rental REST API** built with **Spring Boot**, **Spring Security (JWT)**, and **PostgreSQL**.  
It allows users to browse available cars and make rentals, while merchants can manage their own cars (add, update, delete).

---

## 🧩 Features

### 🔐 Authentication & Authorization
- Login with JWT token generation
- Role-based access control (`USER`, `MERCHANT`)
- Secure endpoints with Spring Security

### 🚘 Car Management (Merchant)
- Add, update, and delete cars (only for authenticated merchants)
- Each car is linked to a specific merchant
- Merchants can view only their own cars

### 📦 Rental Management (User)
- Rent a car if available
- Return a car after rental period
- Prevent multiple rentals of the same car

### 🧰 Tech Stack
- **Java 21**
- **Spring Boot 3**
- **Spring Security (JWT)**
- **Spring Data JPA**
- **PostgreSQL**
- **Docker**
  
---

## ⚙️ Setup Instructions

### 1. Clone the Repository

git clone https://github.com/ElshanAlasgarov/car-rental.git
cd car-rental 


### 2. Configure Database

spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/car_rental
    username: postgres
    password: your_password

### 🧠 Example Endpoints

| Method | Endpoint         | Description   |
| ------ | ---------------- | ------------- |
| POST   | `/api/cars`      | Add a new car |
| PUT    | `/api/cars/{id}` | Update a car  |
| DELETE | `/api/cars/{id}` | Delete a car  |
| GET    | `/api/cars/my`   | Get your cars |

| Method | Endpoint                   | Description        |
| ------ | -------------------------- | ------------------ |
| POST   | `/api/rentals`             | Rent a car         |
| PUT    | `/api/rentals/return/{id}` | Return rented car  |
| GET    | `/api/rentals/my`          | Get rental history |


# 🚀 Practice01 - Spring Boot CRUD REST API

This is a beginner-friendly backend project built using **Spring Boot** to practice and understand core backend concepts like REST APIs, CRUD operations, MongoDB integration, and layered architecture.

---

## 📌 Features

- ✅ CRUD Operations (Create, Read, Update, Delete)
- ✅ RESTful API Design
- ✅ MongoDB Database Integration
- ✅ Layered Architecture:
  - Controller
  - Service
  - Repository
- ✅ Exception Handling with ResponseEntity
- ✅ Lombok for reducing boilerplate code
- ✅ Indexed Fields using MongoDB annotations
------------------------------------------------------------------------------------------------

## 🛠️ Tech Stack

- Java
- Spring Boot
- MongoDB
- Spring Data MongoDB
- Lombok
- Maven
------------------------------------------------------------------------------------------------

## 📂 Project Structure
practice01
│── controller
│── service
│── repository
│── model (POJOs)
------------------------------------------------------------------------------------------------

## 📊 Entities

### 👨‍🎓 Student
- `rollNo` (Unique, Indexed)
- Other basic fields

### 👨‍🏫 Teacher
- `subject` (Indexed)
- Other basic fields

## 🔗 API Endpoints (Sample)

### Student APIs
- `POST /students` → Create Student  
- `GET /students` → Get All Students  
- `GET /students/{id}` → Get Student by ID  
- `PUT /students/{id}` → Update Student  
- `DELETE /students/{id}` → Delete Student  

### Teacher APIs
- `POST /teachers`
- `GET /teachers`
- `PUT /teachers/{id}`
- `DELETE /teachers/{id}`
-----------------------------------------------------------------------------------------------


💡 What I Learned
- Building REST APIs using Spring Boot
- Implementing CRUD operations
- Working with MongoDB and indexing
- Writing clean backend architecture
- Using Lombok to simplify code
- Handling exceptions properly
- ---------------------------------------------------------------------------------------------


📈 Future Improvements
- Add validation (Hibernate Validator)
- Add Swagger for API documentation
- Add authentication (JWT)
- Deploy project on cloud
------------------------------------------------------------------------------------------------

👨‍💻 Author
# Name: LAKSHYA SONI
# Status: Learning Backend Development 🚀

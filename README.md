# WorkSphere

A multi-tenant workforce management SaaS platform built using Spring Boot and PostgreSQL, featuring JWT Authentication, Role-Based Access Control (RBAC), Tenant Isolation, Leave Management, and Task Management capabilities.

---

## Overview

WorkSphere is a full-stack SaaS application designed to help organizations manage users, roles, tasks, and employee leave workflows securely.

The application follows a multi-tenant architecture, ensuring that each organization operates within its own isolated environment while sharing the same application infrastructure.

---

## Features

### Authentication & Security

* User Registration
* User Login
* JWT-Based Authentication
* Spring Security Integration
* Protected REST APIs

### Role-Based Access Control (RBAC)

* Admin and Member Roles
* Permission-Based Access
* Secure Endpoint Authorization

### Multi-Tenant Architecture

* Tenant Isolation
* Organization-Specific Data Access
* Scalable SaaS Design Principles

### Leave Management

* Leave Request Creation
* Leave Tracking
* Leave Approval Workflow
* Leave Rejection Workflow
* Employee Leave History

### Task Management

* Task Creation
* Task Assignment to Employees
* Priority Levels (Low, Medium, High)
* Task Status Tracking
* Admin Task Overview
* Employee Task Dashboard
* Task Progress Updates

### User Management

* User Listing
* Organization-Based User Access
* Tenant-Aware User Data

### Database Management

* PostgreSQL Integration
* JPA / Hibernate ORM
* Persistent Data Storage

---

## Tech Stack

### Backend

* Java 21
* Spring Boot
* Spring Security
* Spring Data JPA
* Hibernate

### Frontend

* React
* Axios
* CSS

### Database

* PostgreSQL

### Authentication

* JWT (JSON Web Tokens)

### Build Tool

* Maven

### Version Control

* Git
* GitHub

---

## Project Structure

```text
src/main/java/com/Saas/project
├── config
├── controller
├── dto
├── entity
├── repo
├── service
└── ProjectApplication.java
```

---

## Architecture Highlights

* RESTful API Design
* Layered Architecture
* DTO-Based Request and Response Handling
* Repository Pattern
* Service Layer Abstraction
* JWT Authentication Flow
* Role-Based Authorization
* Tenant-Aware Data Access
* Multi-Tenant SaaS Architecture

---

## Current Functionalities

### Authentication

* User Registration
* User Login
* JWT Token Generation
* JWT Validation

### Tenant Management

* Tenant Creation
* Tenant Isolation
* Organization-Specific Access

### User Management

* User Management
* Role Assignment
* User Authorization

### Leave Management

* Apply Leave
* View Personal Leaves
* View Organization Leaves
* Approve Leave
* Reject Leave

### Task Management

* Create Tasks
* Assign Tasks to Users
* View Assigned Tasks
* View Organization Tasks
* Update Task Status
* Track Task Progress

### Authorization

* Admin Access Control
* Member Access Control
* Protected Endpoints

---

## API Modules

### Authentication APIs

* Register
* Login
* Join Organization

### User APIs

* View Users

### Leave APIs

* Apply Leave
* View Leaves
* Approve Leave
* Reject Leave

### Task APIs

* Create Task
* View All Tasks
* View My Tasks
* Update Task Status

---

## Future Enhancements

* Swagger / OpenAPI Documentation
* Docker Containerization
* Attendance Management
* Employee Directory
* Notification System
* Audit Logging
* Cloud Deployment (AWS/Azure)
* Email Notifications
* Analytics Dashboard

---

## Learning Outcomes

This project was developed to gain practical experience in:

* Spring Boot Development
* Spring Security
* JWT Authentication
* Role-Based Access Control
* Multi-Tenant SaaS Architecture
* REST API Development
* PostgreSQL Database Design
* JPA / Hibernate
* Frontend-Backend Integration
* Software Design Principles

---

## Project Status

✅ Core Features Completed

### Implemented Modules

* Authentication & Authorization
* Multi-Tenant Architecture
* User Management
* Leave Management
* Task Management
* Role-Based Access Control (RBAC)

WorkSphere currently functions as a complete workforce management SaaS prototype and demonstrates secure multi-tenant application development using Spring Boot and React.

---

## Author

**Chelluboina Durga Sreeram**

Electronics & Communication Engineering Student

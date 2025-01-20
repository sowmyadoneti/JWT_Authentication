"# JWT_Authentication" 
# Product Inventory Management Backend Application

## Overview

This Spring Boot application is designed to manage a products inventory system. It consists of two main services: 

1. **Token Service**: Handles the generation of JWT tokens with specific permissions for secure API access.
2. **Products Service**: Manages the product inventory using CRUD operations, with access control based on JWT token permissions.

The backend uses a PostgreSQL database to store tokens and product data. The project emphasizes security, flexibility, and maintainability.

---

## Features

### Token Service
The **Token Service** generates JWT tokens to grant permissions for accessing the Products service. It includes the following endpoints:

- **Endpoint A**: Generates a token with `read_product` permission.
- **Endpoint B**: Generates a token with `manage_product` permission.
- **Endpoint C**: Generates a token with both `read_product` and `manage_product` permissions.
- **Endpoint D**: Generates a token with `admin` permission.

#### Key Features:
- Tokens are **valid for 10 minutes**.
- Ensures **only one token is valid at a time** by invalidating previous tokens.

### Products Service
The **Products Service** provides endpoints for managing the product inventory with CRUD operations and supports both soft and hard delete functionality.

#### API Access Rules:
- **`read_product`**: Allows access to read operations for **active products** only.
- **`manage_product`**: Enables create, update, and soft delete operations for active products.
- **`admin`**: Grants full access, including:
  - Reading active and soft-deleted products.
  - Hard delete capabilities.

#### Soft vs. Hard Delete:
- **Soft Delete**: Marks the product as inactive without removing it from the database.
- **Hard Delete**: Permanently removes the product from the database.

---

## Database Schema

The application uses a MYSQL database with two primary tables:

1. **Tokens Table**:
   - Stores information about generated JWT tokens and their validity status.
   - Ensures only one token remains valid at a time.

2. **Products Table**:
   - Contains fields for product details (e.g., ID, name, description, price, status).
   - Includes a status flag to support soft delete functionality.

---

## Prerequisites

- **Java 17** or higher
- **Maven** (for dependency management)
- **MYSQL** (database)
- **Postman** (or any API testing tool for manual testing)

---




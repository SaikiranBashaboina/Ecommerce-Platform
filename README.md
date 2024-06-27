# Ecommerce Platform

## Overview
This repository contains an Ecommerce Platform designed to facilitate secure and efficient online shopping experiences. The platform provides functionalities for both users and admins, including authentication, product management, and order processing.

## Features

### Admin Features
- **Authentication and Authorization**: Secure access for admin users.
- **Product Management**: Comprehensive functionalities for adding, editing, and managing products.
- **Order Management**: Oversee and manage the entire order lifecycle from acceptance to delivery.

### User Features
- **Authentication and Authorization**: Secure access for regular users.
- **Product Browsing**: Browse through a variety of products.
- **Order Placement**: Place orders and manage order history.
- **Order Tracking**: Track the status of orders from acceptance to delivery.

## Technologies Used

- **Frontend**: Angular
- **Backend**: Spring Boot
- **Database**: MySQL

## Project Structure

- **Frontend**: Located in the `frontend` directory, built with Angular.
- **Backend**: Located in the `backend` directory, built with Spring Boot.
- **Database**: SQL scripts and configuration files for MySQL.

## Installation and Setup

### Prerequisites

- Node.js
- Angular CLI
- Java (JDK)
- MySQL

### Frontend

1. Navigate to the `frontend` directory:
    ```bash
    cd frontend
    ```
2. Install the dependencies:
    ```bash
    npm install
    ```
3. Start the Angular development server:
    ```bash
    ng serve
    ```
   The frontend application will be available at `http://localhost:4200`.

### Backend

1. Navigate to the `backend` directory:
    ```bash
    cd backend
    ```
2. Install the dependencies and build the project:
    ```bash
    ./mvnw install
    ```
3. Start the Spring Boot application:
    ```bash
    ./mvnw spring-boot:run
    ```
   The backend application will be available at `http://localhost:8080`.

### Database

1. Install MySQL and create a database:
    ```sql
    CREATE DATABASE ecommerce_platform;
    ```
2. Update the database configuration in the `application.properties` file located in the `backend/src/main/resources` directory:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce_platform
    spring.datasource.username=yourUsername
    spring.datasource.password=yourPassword
    ```

## Usage

1. Access the Angular frontend at `http://localhost:4200`.
2. Perform user or admin tasks such as browsing products, placing orders, or managing the product catalog.
3. The frontend interacts with the backend APIs hosted at `http://localhost:8080`.

## Screenshots
![Screenshot (46)](https://github.com/SaikiranBashaboina/Ecommerce-Platform/assets/157346742/85d0c271-4d02-4541-9cd5-92fda8de61bf)
![Screenshot (47)](https://github.com/SaikiranBashaboina/Ecommerce-Platform/assets/157346742/329763bc-3f91-42df-a920-1478cae1b389)
![Screenshot (48)](https://github.com/SaikiranBashaboina/Ecommerce-Platform/assets/157346742/b9c82df5-2661-4b85-89ba-05ff1ffa3966)

### Admin Interface
![Screenshot (49)](https://github.com/SaikiranBashaboina/Ecommerce-Platform/assets/157346742/8999ca69-f847-4edd-9af8-19c9f61bd6a6)
![Screenshot (50)](https://github.com/SaikiranBashaboina/Ecommerce-Platform/assets/157346742/868b0f0e-0e16-4470-86a7-387194432d64)
![Screenshot (51)](https://github.com/SaikiranBashaboina/Ecommerce-Platform/assets/157346742/45ddac92-37d8-49b9-a0d3-6a8fc3055d4a)

### User Interface
![Screenshot (52)](https://github.com/SaikiranBashaboina/Ecommerce-Platform/assets/157346742/99418d12-0f8b-4d75-ad23-4becfd2229c5)
![Screenshot (53)](https://github.com/SaikiranBashaboina/Ecommerce-Platform/assets/157346742/6cd09d91-cc47-4bd6-88ea-54a562fd6a5c)
![Screenshot (54)](https://github.com/SaikiranBashaboina/Ecommerce-Platform/assets/157346742/cdb23ff0-86f0-4d0d-8f80-f53f767e2809)

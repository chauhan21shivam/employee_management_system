# Employee Management System

This project is an **Employee Management System** built using Java and JDBC technology. It allows administrators to manage employees, including adding, updating, removing, and viewing employee details. Employees can also update their own details and view their information.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Setup Instructions](#setup-instructions)
- [Usage](#usage)
- [Database Schema](#database-schema)
- [Class Structire](#Class-Structure)
- [Project Structure](#Project-Structure)
- [Author](#author)


## Features

### Admin Features
- **Login:** Admin can log in to the system using their credentials.
- **Insert Employee:** Add a new employee to the database.
- **Remove Employee:** Delete an employee record from the database.
  - Note: Admin cannot be removed.
- **Update Employee:** Modify an existing employee’s details.
- **View Employee:** View the details of a specific employee by ID.
- **View All Employees:** Display all employee records.

### Employee Features
- **Login:** Employees can log in using their ID and password.
- **Update Data:** Employees can update their own details (name, phone, password).
- **View Employee:** Employees can view their own details.

## Technologies Used

- **Java SE:** Core Java for the application logic.
- **JDBC (Java Database Connectivity):** To interact with the PostgreSQL database.
- **PostgreSQL:** Database management system for storing employee data.

## Setup Instructions

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/yourusername/employee_management_system.git

2. **Configure the Database:**

- **Ensure PostgreSQL is installed and running on your machine.**
- **Create a new database called emp_management_system.**
- **Create a table using the schema provided below.**
- **Update the database connection details in the EmployeeDao.java file.**
```bash
  String url="jdbc:postgresql://localhost:5432/emp_management_system";
  String user="postgres";
  String password="root";
```
3. **Compile the Project:**

- **Use an IDE like Eclipse or IntelliJ IDEA to compile the project.**
- **Alternatively, you can use the following command:**
```bash
  javac -d bin -sourcepath src src/view/Run.java
```
4. **Run the Project:**

- **After compiling, run the project:**
```bash
  java -cp bin view.Run
```
## Usage
1. **Admin Login:**

- **Start the application and choose "Admin Login".**
- **Enter admin credentials to access the admin panel.**

2. **Employee Login:**

- **Start the application and choose "Employee Login".**
- **Enter employee credentials to access the employee panel.**

3. **Admin Operations:**

- **Perform actions like adding, updating, removing, and viewing employees.**
  
4. **Employee Operations:**

- **Employees can update their own details and view their information.**
  
### Database Schema
```sql
CREATE TABLE employee (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    salary DOUBLE PRECISION,
    phone BIGINT,
    password VARCHAR(50),
    role VARCHAR(20)
);
```
## Class Structure
`controller.EmployeeController`
Handles all the business logic related to employee management, including login validation, CRUD operations, and role-specific functionalities.

`model.dao.EmployeeDao`
Manages the database interactions using JDBC, including executing SQL queries for employee data manipulation.

`model.dto.Employee`
Represents the Employee data model with fields such as `id`, `name`, `salary`, `phone`, `password`, and `role`.

`view.Run`
Provides the user interface via the console, enabling interaction with the system through a menu-driven approach.

  
### Project Structure
```
employee_management_system/
├── controller/
│   └── EmployeeController.java
├── model/
│   ├── dao/
│   │   └── EmployeeDao.java
│   └── dto/
│       └── Employee.java
└── view/
    └── Run.java
```
## Author
**[Shivam Chauhan](https://www.linkedin.com/in/chauhan21shivam)**

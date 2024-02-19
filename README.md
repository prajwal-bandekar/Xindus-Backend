# Entity Relationship Diagram
![Entity Relationship Diagram (2)](https://github.com/prajwal-bandekar/Xindus-Backend/assets/140521722/edbefc70-ffb9-4180-948c-a5799042fee4)


# Xindus Backend Assignment
### Teachnolgies used
#### Backend
 - Java
 - Spring Boot
   - Spring Data JPA: Simplifies data access
   - MySQL Driver: Connects Java applications to MySQL Database
   - Spring Web Services: Simplifies REST API based web services.
   - Spring Security: Handles authentication and access control.
   - SpringBoot Dev Tools: Enhances development productivity.
   - Lombok: Reduces boilerplate code.
   - Swagger: API documentation and testing.
   
#### Version Control
 - Git: Distributed version control system.


## Prerequisites
Before running the application, ensure you have the following installed on your system:

Java Development Kit (JDK)
MySQL Database
IDE

 <!-- Add ER Diagram  -->

## Clone the Repository

```bash
 git clone https://github.com/prajwal-bandekar/Xindus-Backend
```
## Configure Backend
Navigate to the 'WishList_Management' folder

- Update the application.properties file with your MySQL database configuration.


     - springboot/src/main/resources/application.properties
```bash
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name?createDatabaseIfNotExist=true
spring.datasource.username=your_username
spring.datasource.password=your_password
```

## Usage
Run this as a Springboot App.

### REST API Endpoints
According to the Entity Relationship Diagram, these enity classes have been implemented.These REST API endpoints will allow you to Create, Read, Update and Delete (using the JPARepository Interface via Spring Data JPA) each entity while also being mapped to each other via one to many mapping as in the ER Diagram.
#### User Entity
Create User:
 - POST /user

Update User:
 - PUT /user/{uID}

Fetch User:
 - GET /user/{uID}

Delete User:
 - DELETE /user/{uID}

#### Wishlist Entity

Create Wishlist:
 - POST /wishlist/{uID}

Update Wishlist:
 - PUT /wishlist/{uID}

Fetch Wishlist:
 - GET /wishlist/{wID}

Delete Wishlist:
 - DELETE /wishlist/{wID}

#### Product Entity
Create Product:
 - POST /product/{wID}

Update Product:
 - PUT /product/{wID}

Fetch Product:
 - GET /product/{pID}

Delete Product:
 - DELETE /product/{pID}

 These End points have been sucessfully verified using POSTMAN.

 *Any exceptions that could have been happened (for edge cases or null value cases) have been taken care by bringing in a Global exception handler class.*

Viola! the app will be running locally on your machine.

#### To view Swagger API docs
Run the server and browse to

```bash
http://localhost:8080/swagger-ui/index.html#/
```

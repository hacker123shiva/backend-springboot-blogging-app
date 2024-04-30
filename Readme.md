# Spring Boot Backend Setup for Blogging App

This project provides a Spring Boot backend for a blogging application.

## Installation

1. **Clone the repository:**

   ```bash
   git clone https://github.com/hacker123shiva/backend-springboot-blogging-app.git
   ```

2. **Open your project in an IDE:**

   Open the project in your preferred IDE (STS, Eclipse, IntelliJ, or VSCode) as a Maven project.

3. **Update Maven dependencies:**

   Check if Maven automatically updates your application. If not, manually update the application by running:

   ```bash
   mvn clean install
   ```

4. **Run the Spring Boot server:**

   Start the server using Spring Boot command.

   If your IDE supports it, click "Run as Spring Boot Application" or "Run as Java Application".
   Otherwise, use the command:

   ```bash
   mvn spring-boot:run
   ```

   Ensure the server starts successfully.

5. **Access Swagger UI:**

   Once the server is running, open your web browser and go to [http://localhost:9000/swagger-ui/index.html](http://localhost:9000/swagger-ui/index.html) to access the Swagger UI. This provides documentation for all available APIs.

## Database Configuration

If your application encounters any issues related to the database, modify the `application.properties` file found in the `resources` folder.

```properties
spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:${MYSQL_PORT:3306}/blog_app_apis
spring.datasource.username=${MYSQL_USER:root}
spring.datasource.password=${MYSQL_PASSWORD:root}
spring.jpa.show-sql=true
spring.datasource.initialization-mode=always
server.port=9000
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update
spring.servlet.multipart.max-file-size=10MB
spring.servlet.multipart.max-request-size=10MB
project.image=images/
logging.level.org.springframework.security=DEBUG
spring.profiles.active=dev
```

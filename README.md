# Email Service

The Email Service is designed to handle asynchronous email notifications using Kafka. It is a lightweight service responsible for sending emails efficiently.

## Features

- **Send Emails**: Provides functionality to send emails asynchronously.

## Technologies Used

- **Spring Boot**: Framework for building the service.
- **Spring Kafka**: Used for integrating Kafka to handle asynchronous messaging.
- **JavaMail API**: Used for sending emails.

## Dependencies

- `spring-boot-starter-web`: Starter for building web applications.
- `spring-kafka`: Provides Kafka integration.
- `spring-boot-devtools`: Provides additional development tools.
- `spring-boot-configuration-processor`: For configuration properties support.
- `lombok`: Reduces boilerplate code with annotations.
- `spring-boot-starter-test`: For testing support.
- `spring-kafka-test`: Kafka test utilities.
- `javax.mail`: For email functionalities.

## Configuration

- **`application.properties`**:

    ```properties
    spring.application.name=EmailService
    server.port=8282
    ```

## Project Structure

- **`src/main/java`**: Contains the Java source code for the service.
- **`src/main/resources`**: Contains configuration files such as `application.properties`.
- **`src/test/java`**: Contains unit and integration tests.

## Additional Notes

- This service uses Kafka for asynchronous email sending, and the integration follows standard Kafka configurations.
- The structure of the project is minimal, focusing on the essentials required for Kafka integration and email sending.

## Related Services

- **[Product Service](https://github.com/AmanPr01/E-Commerce)**: Manages product information and operations.
- **[User Service](https://github.com/AmanPr01/UserService)**: Manages user authentication and authorization.
- **[Payment Service](https://github.com/AmanPr01/PaymentService)**: Manages payment processing and transactions.

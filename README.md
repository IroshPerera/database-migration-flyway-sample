# Spring Boot Flyway PostgreSQL Example

## Overview

This project demonstrates how to implement Flyway database migrations in a Spring Boot application using PostgreSQL. It provides a step-by-step guide for setting up Flyway, creating and managing versioned SQL scripts, and ensuring your database schema stays consistent across environments.

## Features

- Spring Boot integration with Flyway
- PostgreSQL as the database
- Version-controlled database migrations
- Sample SQL migration scripts

## Prerequisites

- Java 17 or later
- Maven 3.6 or later
- PostgreSQL database

## Setup

1. **Clone the Repository**

    ```bash
    git clone https://github.com/IroshPerera/database-migration-flyway-sample.git
    cd database-migration-flyway-sample
    ```

2. **Configure PostgreSQL**

   Ensure PostgreSQL is installed and running. Create a database for your application.

3. **Update Application Properties**

   Modify `src/main/resources/application.properties` with your PostgreSQL configuration:

    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/your-database-name
    spring.datasource.username=your-username
    spring.datasource.password=your-password
    spring.flyway.enabled=true
    ```

4. **Add Flyway Dependencies**

   Ensure the following dependencies are included in your `pom.xml`:

    ```xml
    <dependency>
        <groupId>org.flywaydb</groupId>
        <artifactId>flyway-core</artifactId>
    </dependency>
    <dependency>
        <groupId>org.postgresql</groupId>
        <artifactId>postgresql</artifactId>
    </dependency>
    ```

5. **Create Migration Scripts**

   Place your SQL migration scripts in the `src/main/resources/db/migration` directory. Naming convention should follow `V1__Initial_setup.sql`, `V2__Add_some_feature.sql`, etc.

6. **Run the Application**

   Use Maven to build and run your application:

    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

7. **Verify Migration**

   Check your PostgreSQL database to ensure the migrations have been applied.

## Example Migration Script

Here's a sample migration script (`V1__Create_table.sql`):

```sql
CREATE TABLE example (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);
```

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

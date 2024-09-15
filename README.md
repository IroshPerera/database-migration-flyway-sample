# Spring Boot Flyway PostgreSQL Example

## Overview

This project demonstrates how to implement Flyway database migrations in a Spring Boot application using PostgreSQL. It
provides a step-by-step guide for setting up Flyway, creating and managing versioned SQL scripts, and ensuring your
database schema stays consistent across environments.

## What is Database Migration?

Database migration is the process of moving data from one or more databases to another while ensuring that the data
remains accessible and usable. This process is particularly important when updating the database schema as part of
continuous development. By versioning each schema change, database migration tools ensure consistency across different
environments (development, staging, production).

### Why is it Useful?

- **Maintains Data Integrity:** When applications grow, database structures evolve. Migration ensures these changes are
  applied in an orderly manner across environments without data loss.

- **Version Control for Schemas:** Like code versioning, database migration allows tracking of each change, rollback to
  previous versions if needed, and smooth application upgrades.

- **Automates Schema Updates:** Automated migrations reduce human error by managing scripts that evolve your database in
  sync with your code.

## Why Flyway? 
- Flyway’s lightweight nature and tight integration with Spring Boot make it an ideal tool for managing database changes
in a controlled manner. Each migration is tracked and applied automatically, ensuring smooth and reliable database
evolution without manual intervention.

## Features

- Spring Boot integration with Flyway
- PostgreSQL as the database
- Version-controlled database migrations
- Sample SQL migration scripts

## Prerequisites

- Java 17 or later
- Maven 3.6 or later
- PostgreSQL database / Your preferred database

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
    spring.datasource.driver-class-name=org.postgresql.Driver // Your driver class name
    
    spring.jpa.show-sql=true
    spring.jpa.hibernate.ddl-auto=none

    spring.flyway.enabled=true
    spring.flyway.baseline-on-migrate=true
    spring.flyway.locations=classpath:db/migration
    ```

4. **Add Flyway Dependencies**

   Ensure the following dependencies are included in your `pom.xml`:

    ```xml
    <dependencies>
        <dependency>
            <groupId>org.flywaydb</groupId>
            <artifactId>flyway-core</artifactId>
        </dependency>
        <dependency>
            <groupId>org.flywaydb</groupId>
            <artifactId>flyway-database-postgresql</artifactId>
        </dependency>
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <scope>runtime</scope>
        </dependency>
    </dependencies>
    ```

5. **Create Migration Scripts**

   Place your SQL migration scripts in the `src/main/resources/db/migration` directory. Naming convention should follow
   `V1__Initial_setup.sql`, `V2__Add_some_feature.sql`, etc.

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
CREATE TABLE example
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);
```

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

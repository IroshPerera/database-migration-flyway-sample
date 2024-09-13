package com.webmotech.database_migration_flyway_sample_project.repository;

import com.webmotech.database_migration_flyway_sample_project.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, String> {
}

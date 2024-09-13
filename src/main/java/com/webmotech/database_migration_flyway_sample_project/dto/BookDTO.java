package com.webmotech.database_migration_flyway_sample_project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookDTO implements Serializable {
    private String bookId;
    private String bookName;
    private String author;
    private Double price;
}

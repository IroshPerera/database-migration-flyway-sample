package com.webmotech.database_migration_flyway_sample_project.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "book")
public class BookEntity implements Serializable {
    @Id
    @Column(name = "bookid")
    private String bookId;
    @Column(name = "bookname")
    private String bookName;
    private String author;
    private Double price;

}

package com.webmotech.database_migration_flyway_sample_project.service;


import com.webmotech.database_migration_flyway_sample_project.dto.BookDTO;



public interface BookService {
    BookDTO saveBook(BookDTO bookDTO);
    BookDTO getBook(String bookId);
    BookDTO updateBook(BookDTO bookDTO);
    void deleteBook(String bookId);

}

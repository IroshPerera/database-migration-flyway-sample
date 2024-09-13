package com.webmotech.database_migration_flyway_sample_project.service.impl;

import com.webmotech.database_migration_flyway_sample_project.dto.BookDTO;
import com.webmotech.database_migration_flyway_sample_project.entity.BookEntity;
import com.webmotech.database_migration_flyway_sample_project.repository.BookRepository;
import com.webmotech.database_migration_flyway_sample_project.service.BookService;
import com.webmotech.database_migration_flyway_sample_project.util.map.GlobalMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BookServiceIMPL implements BookService {
    private final BookRepository bookRepository;
    private final GlobalMapper globalMapper;

    @Override
    public BookDTO saveBook(BookDTO bookDTO) {

        if (bookRepository.existsById(bookDTO.getBookId()))
            throw new RuntimeException("Book already exists");


        BookEntity bookEntity = globalMapper.bookDTOToBookEntity(bookDTO);
        bookEntity = bookRepository.save(bookEntity);
        return globalMapper.bookEntityToBookDTO(bookEntity);

    }

    @Override
    public BookDTO getBook(String bookId) {
        BookEntity bookEntity = bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found"));
        return globalMapper.bookEntityToBookDTO(bookEntity);

    }

    @Override
    public BookDTO updateBook(BookDTO bookDTO) {
        BookEntity bookEntity = bookRepository.findById(bookDTO.getBookId()).orElseThrow(() -> new RuntimeException("Book not found"));
        bookEntity = globalMapper.bookDTOToBookEntity(bookDTO);
        bookEntity = bookRepository.save(bookEntity);
        return globalMapper.bookEntityToBookDTO(bookEntity);
    }

    @Override
    public void deleteBook(String bookId) {
        if (!bookRepository.existsById(bookId))
            throw new RuntimeException("Book not found");
        bookRepository.deleteById(bookId);

    }


}

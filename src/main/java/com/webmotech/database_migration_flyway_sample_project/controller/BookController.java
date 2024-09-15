package com.webmotech.database_migration_flyway_sample_project.controller;

import com.webmotech.database_migration_flyway_sample_project.dto.BookDTO;
import com.webmotech.database_migration_flyway_sample_project.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("/health")
    public String health() {
        return "Book Service is up and running";
    }

    @PostMapping
    public ResponseEntity<?> saveBook(@RequestBody BookDTO bookDTO, BindingResult bindResult) {
        if (bindResult.hasErrors()) {
            return ResponseEntity.badRequest().body("Invalid Request");
        }

        try {
            return ResponseEntity.ok(bookService.saveBook(bookDTO));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PutMapping
    public ResponseEntity<?> updateBook(@RequestBody BookDTO bookDTO, BindingResult bindResult) {
        if (bindResult.hasErrors()) {
            return ResponseEntity.badRequest().body("Invalid Request");
        }

        try {
            return ResponseEntity.ok(bookService.updateBook(bookDTO));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping("/{bookId}")
    public ResponseEntity<?> getBook(@PathVariable String bookId) {
        try {
            return ResponseEntity.ok(bookService.getBook(bookId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<?> deleteBook(@PathVariable String bookId) {
        try {
            bookService.deleteBook(bookId);
            return ResponseEntity.ok("Book deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

}

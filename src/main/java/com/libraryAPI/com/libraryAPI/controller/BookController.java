package com.libraryAPI.com.libraryAPI.controller;

import com.libraryAPI.com.libraryAPI.dto.BookDto;
import com.libraryAPI.com.libraryAPI.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping()
    public ResponseEntity<List<BookDto>> booksList() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBook(@PathVariable long id) {
        try {
            BookDto bookDto = bookService.getBook(id);
            return ResponseEntity.ok(bookDto);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public ResponseEntity<BookDto> addBook(@RequestBody @Valid BookDto bookDto) {
        BookDto savedBook = bookService.addBook(bookDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDto> editBook(@PathVariable long id, @RequestBody @Valid BookDto bookDto) {
        try {
            BookDto editedBook = bookService.editBook(id, bookDto);
            return ResponseEntity.ok(editedBook);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable long id) {
        try {
            bookService.deleteBook(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}

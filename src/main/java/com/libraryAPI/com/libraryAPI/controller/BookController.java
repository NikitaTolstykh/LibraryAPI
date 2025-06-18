package com.libraryAPI.com.libraryAPI.controller;

import com.libraryAPI.com.libraryAPI.dto.BookDto;
import com.libraryAPI.com.libraryAPI.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}

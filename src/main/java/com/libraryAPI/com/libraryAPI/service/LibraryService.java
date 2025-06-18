package com.libraryAPI.com.libraryAPI.service;

import com.libraryAPI.com.libraryAPI.dto.BookDto;

import java.util.List;

public interface LibraryService {
    List<BookDto> getAllBooks();
    BookDto getBook(long id);
    BookDto addBook(BookDto bookDto);
    BookDto editBook(long id, BookDto bookDto);
    void deleteBook(long id);
}

package com.libraryAPI.com.libraryAPI.service;

import com.libraryAPI.com.libraryAPI.dto.BookDto;
import com.libraryAPI.com.libraryAPI.entity.Book;
import com.libraryAPI.com.libraryAPI.mapper.BookMapper;
import com.libraryAPI.com.libraryAPI.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookService(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    public List<BookDto> getAllBooks() {
        return bookMapper.listBooksToDto(bookRepository.findAll());
    }

    public BookDto getBook(long id) {
        return bookMapper.bookToDto(bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Book not found"))
        );
    }

    @Transactional
    public BookDto addBook(BookDto bookDto) {
        Book book = bookMapper.bookToEntity(bookDto);
        return bookMapper.bookToDto(bookRepository.save(book));
    }

    @Transactional
    public BookDto editBook(long id, BookDto bookDto) {
        Book fromDb = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Book not found"));

        fromDb.setIsbn(bookDto.getIsbn());
        fromDb.setTitle(bookDto.getTitle());
        fromDb.setAuthor(bookDto.getAuthor());
        fromDb.setPublisher(bookDto.getPublisher());
        fromDb.setType(bookDto.getType());

        bookRepository.save(fromDb);
        return bookMapper.bookToDto(fromDb);
    }

    @Transactional
    public void deleteBook(long id) {
        bookRepository.deleteById(id);
    }

}

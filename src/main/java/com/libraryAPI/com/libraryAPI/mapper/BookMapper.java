package com.libraryAPI.com.libraryAPI.mapper;

import com.libraryAPI.com.libraryAPI.dto.BookDto;
import com.libraryAPI.com.libraryAPI.entity.Book;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookDto bookToDto(Book book);
    Book bookToEntity(BookDto bookDto);
    List<BookDto> listBooksToDto(List<Book> books);

}

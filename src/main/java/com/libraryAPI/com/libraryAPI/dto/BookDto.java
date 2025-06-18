package com.libraryAPI.com.libraryAPI.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private Long id;
    @NotBlank(message = "Book must have ISBN")
    private String isbn;
    @NotBlank(message = "Book must have title")
    private String title;
    @NotBlank(message = "Book must have author")
    private String author;
    private String publisher;
    private String type;

}

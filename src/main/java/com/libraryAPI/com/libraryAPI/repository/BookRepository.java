package com.libraryAPI.com.libraryAPI.repository;

import com.libraryAPI.com.libraryAPI.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}

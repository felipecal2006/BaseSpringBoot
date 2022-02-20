package com.example.domain.model.book.gateway;

import com.example.domain.model.book.Book;

import java.util.List;

public interface BookRepository {
    Book findById(String isbn);
    List<Book> findAll();
}
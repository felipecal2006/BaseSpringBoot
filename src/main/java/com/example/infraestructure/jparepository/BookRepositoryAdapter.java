package com.example.infraestructure.jparepository;

import com.example.domain.model.book.Book;
import com.example.domain.model.book.gateway.BookRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookRepositoryAdapter implements BookRepository {
    BookDataRepository repository;
    @Override
    public Book findById(String isbn) {
        return Optional.of(repository.findById(isbn)).get().orElse(new Book());
    }

    @Override
    public List<Book> findAll() {
        return (List<Book>) repository.findAll();
    }
}

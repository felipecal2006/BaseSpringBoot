package com.example.domain.usecase.book;

import com.example.domain.model.book.Book;
import com.example.domain.model.book.gateway.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateBookUseCase {
    @Autowired
    private BookRepository bookRepository;
    public Book saveBook(Integer isbn, String name){
        return bookRepository.save(Book.builder().isbn(isbn).name(name).build());
    }
}

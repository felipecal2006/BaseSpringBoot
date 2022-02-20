package com.example.domain.usecase;

import com.example.domain.model.book.Book;
import com.example.domain.model.book.gateway.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class QueryBookUseCase {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAll(){
        return bookRepository.findAll();
    }
    public  Book findById(String isbn){
        return bookRepository.findById(isbn);
    }
}

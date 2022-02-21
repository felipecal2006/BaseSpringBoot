package com.example.domain.usecase.book;

import com.example.domain.model.book.Book;
import com.example.domain.model.book.gateway.BookRepository;
import com.example.infraestructure.message.book.BookCreatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateBookUseCase {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookCreatedEvent bookCreateEvent;
    public Book saveBook(Integer isbn, String name){
        Book book = bookRepository.save(Book.builder().isbn(isbn).name(name).build());
        bookCreateEvent.sendMessage(book);
        return book;
    }
}

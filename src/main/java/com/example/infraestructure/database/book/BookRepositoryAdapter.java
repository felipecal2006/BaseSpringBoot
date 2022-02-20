package com.example.infraestructure.database.book;

import com.example.domain.model.book.Book;
import com.example.domain.model.book.gateway.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookRepositoryAdapter implements BookRepository{

    private final BookDataRepository bookDataRepository;

    @Autowired
    public BookRepositoryAdapter(BookDataRepository bookDataRepository){
        this.bookDataRepository = bookDataRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookDataRepository.findAll().stream()
                .map(this::transformBook)
                .collect(Collectors.toList());

    }

    @Override
    public Book findById(Integer isbn) {
        return bookDataRepository.findById(isbn)
                .map(this::transformBook)
                .orElse(Book.builder().build());
    }

    @Override
    public Book save(Book newBook) {
        return transformBook(bookDataRepository.save(transformBook(newBook)));
    }


    private Book transformBook(BookData b) {
        return Book.builder().isbn(b.getIsbn()).name(b.getName()).build();
    }
    private BookData transformBook(Book b) {
        BookData bookData = new BookData();
        bookData.setIsbn(b.getIsbn());
        bookData.setName(b.getName());
        return bookData;
    }
}

package com.example.infraestructure.web.book;

import com.example.domain.model.book.Book;
import com.example.domain.usecase.book.QueryBookUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookSearchServices {
    @Autowired
    private  QueryBookUseCase queryBookUseCase;

    @GetMapping("/books")
    public List<Book> findAll(){
        return queryBookUseCase.findAll();
    }
    @GetMapping("/book/isbn/{isbn}")
    public Book findByIsbn(@PathVariable("isbn") Integer isbn){
        return queryBookUseCase.findById(isbn);
    }

}

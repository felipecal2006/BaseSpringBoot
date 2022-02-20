package com.example.infraestructure.web.book;

import com.example.domain.model.book.Book;
import com.example.domain.usecase.book.CreateBookUseCase;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BookCreateServices {
    @Autowired
    CreateBookUseCase createBookUseCase;

    @PostMapping(path = "/book", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Book createBook(@RequestBody NewBook newBook) {
        return createBookUseCase.saveBook(newBook.getIsbn(),newBook.getName());
    }

    @Data
    private static class NewBook {
        Integer isbn;
        String name;
    }
}

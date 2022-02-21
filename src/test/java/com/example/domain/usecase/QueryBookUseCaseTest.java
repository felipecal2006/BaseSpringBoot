package com.example.domain.usecase;

import com.example.domain.model.book.Book;
import com.example.domain.usecase.book.QueryBookUseCase;
import com.example.infraestructure.database.book.BookData;
import com.example.infraestructure.database.book.BookDataRepository;
import com.example.infraestructure.database.book.BookRepositoryAdapter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class QueryBookUseCaseTest {
    @Mock
    BookRepositoryAdapter bookRepositoryAdapter;
    @InjectMocks
    QueryBookUseCase queryBookUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("find book by id")
    void findBookById() {
        Book book = Book.builder().isbn(1234).name("prueba1").build();
        when(bookRepositoryAdapter.findById(any())).thenReturn(book);
        Book result = queryBookUseCase.findById(1234);
        Assertions.assertEquals(book, result);
    }

    @Test
    @DisplayName("find all books")
    void findAllBooks() {
        List<Book> books = new ArrayList<>();
        Book book = Book.builder().isbn(1234).name("prueba1").build();
        books.add(book);
        when(bookRepositoryAdapter.findAll()).thenReturn(books);
        List<Book> result = queryBookUseCase.findAll();
        Assertions.assertEquals(book, result.get(0));
    }

}

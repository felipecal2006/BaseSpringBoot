package com.example.infraestructure.database.book;

import com.example.domain.model.book.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class BookRepositoryAdapterTest {
    @Mock
    BookDataRepository bookDataRepository;
    @InjectMocks
    BookRepositoryAdapter bookRepositoryAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("save book")
    void saveBook() {
        Book book = Book.builder().isbn(1234).name("prueba1").build();
        BookData bookData = new BookData();
        bookData.setIsbn(1234);
        bookData.setName("prueba1");
        when(bookDataRepository.save(any())).thenReturn(bookData);
        Book result = bookRepositoryAdapter.save(book);
        Assertions.assertEquals(book,result);
    }

    @Test
    @DisplayName("find all books")
    void findAllBooks()  {
        List<BookData> bookList = new ArrayList<>();
        Book book = Book.builder().isbn(1234).name("prueba1").build();
        BookData bookData = new BookData();
        bookData.setIsbn(1234);
        bookData.setName("prueba1");
        bookList.add(bookData);
        when(bookDataRepository.findAll()).thenReturn(bookList);
        List<Book> result = bookRepositoryAdapter.findAll();
        Assertions.assertEquals(book,result.get(0));
    }

    @Test
    @DisplayName("find book by Id")
    void findBookById()  {
        Book book = Book.builder().isbn(1234).name("prueba1").build();
        BookData bookData = new BookData();
        bookData.setIsbn(1234);
        bookData.setName("prueba1");
        when(bookDataRepository.findById(any())).thenReturn(Optional.of(bookData));
        Book  result = bookRepositoryAdapter.findById(1234);
        Assertions.assertEquals(book,result);
    }
}

package com.example.domain.usecase;

import com.example.domain.model.book.Book;
import com.example.domain.usecase.book.CreateBookUseCase;
import com.example.infraestructure.database.book.BookRepositoryAdapter;
import com.example.infraestructure.message.book.BookCreatedEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

public class CreateBookUseCaseTest {
    @Mock
    BookRepositoryAdapter bookRepositoryAdapter;
    @Mock
    BookCreatedEvent bookCreateEvent;
    @InjectMocks
    CreateBookUseCase createBookUseCase;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("save book")
    void saveBook() {
        Book book = Book.builder().isbn(1234).name("prueba1").build();
        when(bookRepositoryAdapter.save(any())).thenReturn(book);
        doNothing().when(bookCreateEvent).sendMessage(any());
        Book result = createBookUseCase.saveBook(1234,"prueba1");
        Assertions.assertEquals(book, result);
    }
}

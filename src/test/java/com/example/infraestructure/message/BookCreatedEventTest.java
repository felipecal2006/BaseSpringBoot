package com.example.infraestructure.message;

import com.example.domain.model.book.Book;
import com.example.infraestructure.message.book.BookCreatedEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

public class BookCreatedEventTest {
    private static final String BOOK_CREATED = "bookCreated";

    @Mock
    RabbitTemplate rabbitTemplate;
    @InjectMocks
    BookCreatedEvent bookCreatedEvent;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Emit event save book")
    void emitEnvetSaveBook() {
        Book book = Book.builder().isbn(1234).name("prueba1").build();
        String jsonBook="{\"isbn\":1234,\"name\":\"prueba1\"}";
        doNothing().when(rabbitTemplate).convertAndSend(BOOK_CREATED,jsonBook);
        bookCreatedEvent.sendMessage(book);
        verify(rabbitTemplate).convertAndSend(BOOK_CREATED ,jsonBook);
    }
}

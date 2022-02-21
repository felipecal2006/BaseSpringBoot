package com.example.infraestructure.web.book;

import com.example.domain.model.book.Book;
import com.example.domain.usecase.book.QueryBookUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = {BookSearchServices.class})
class BookSearchServicesTest {
    @Autowired
    private MockMvc mvc;
    @MockBean
    QueryBookUseCase queryBookUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("return all books")
    void returnAllBooks() throws Exception {
        List<Book> books = new ArrayList<>();
        books.add(Book.builder().isbn(1234).name("prueba1").build());
        when(queryBookUseCase.findAll()).thenReturn(books);
        String jsonBook = "[{\"isbn\":1234,\"name\":\"prueba1\"}]";
        final ResultActions result =
                mvc.perform(
                        get("/books")
                                .header("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                           );
        result.andExpect(status().isOk())
                .andExpect(content().json(jsonBook));
    }

    @Test
    @DisplayName("return book when search by isbn")
    void returnBookByIsbn() throws Exception {
        Book book = Book.builder().isbn(1234).name("prueba1").build();
        when(queryBookUseCase.findById(any())).thenReturn(book);
        String jsonBook = "{\"isbn\":1234,\"name\":\"prueba1\"}";
        final ResultActions result =
                mvc.perform(
                        get("/book/isbn/1234")
                                .header("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                           );
        result.andExpect(status().isOk())
                .andExpect(content().json(jsonBook));
    }
}

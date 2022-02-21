package com.example.infraestructure.web.book;

import com.example.domain.model.book.Book;
import com.example.domain.usecase.book.CreateBookUseCase;
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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = {BookCreateServices.class})
public class BookCreateServicesTest {
    @Autowired
    private MockMvc mvc;
    @MockBean
    CreateBookUseCase createBookUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Save  book")
    void SaveBook() throws Exception {
        Book book = Book.builder().isbn(1234).name("prueba1").build();
        when(createBookUseCase.saveBook(any(), any())).thenReturn(book);
        String jsonBook = "{\"isbn\":1234,\"name\":\"prueba1\"}";
        final ResultActions result =
                mvc.perform(
                        post("/book")
                                .content("{\"isbn\":1234,\"name\":\"prueba1\"}")
                                .contentType(MediaType.APPLICATION_JSON)
                                .header("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                           );
        result.andExpect(status().isOk())
                .andExpect(content().json(jsonBook));
    }

}

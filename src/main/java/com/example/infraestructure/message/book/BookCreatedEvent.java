package com.example.infraestructure.message.book;

import com.example.domain.model.book.Book;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BookCreatedEvent {
    private static final boolean NON_DURABLE = false;
    private static final String BOOK_CREATED = "bookCreated";
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public BookCreatedEvent(RabbitTemplate template){
        this.rabbitTemplate=template;
    }
    @Bean
    public Queue createdBook() {
        return new Queue(BOOK_CREATED, NON_DURABLE);
    }
    public void sendMessage(Book book)  {
        ObjectMapper objectMapper= new ObjectMapper();
        try {
            String  bookJson = objectMapper.writeValueAsString(book);
            rabbitTemplate.convertAndSend(BOOK_CREATED, bookJson );
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }

}

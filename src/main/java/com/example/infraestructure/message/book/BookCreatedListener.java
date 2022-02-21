package com.example.infraestructure.message.book;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class BookCreatedListener {
    private static final String BOOK_CREATED = "bookCreated";

    @RabbitListener(queues = BOOK_CREATED)
    public void listen(String in) {
        System.out.println("Book created : " + in);
    }

}

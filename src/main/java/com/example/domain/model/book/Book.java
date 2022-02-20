package com.example.domain.model.book;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Book {
    private Integer isbn;
    private String name;
}

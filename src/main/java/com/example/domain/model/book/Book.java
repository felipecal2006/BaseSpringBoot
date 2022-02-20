package com.example.domain.model.book;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name="book")
@NoArgsConstructor
public class Book {
    @Id
    private String isbn;
    private String name;
}

package com.example.infraestructure.database.book;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "books")
public class BookData {
    @Id
    private Integer isbn;
    private String name;
}

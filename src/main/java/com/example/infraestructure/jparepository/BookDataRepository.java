package com.example.infraestructure.jparepository;

import com.example.domain.model.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDataRepository extends JpaRepository<Book,String> {

}

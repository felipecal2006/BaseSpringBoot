package com.example.infraestructure.database.book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDataRepository extends JpaRepository<BookData,Integer> {

}

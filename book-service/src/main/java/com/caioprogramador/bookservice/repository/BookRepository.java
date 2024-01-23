package com.caioprogramador.bookservice.repository;

import com.caioprogramador.bookservice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}

package com.caioprogramador.bookservice.controller;

import com.caioprogramador.bookservice.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book-service")
public class BookController {

    @Autowired
    private Environment environment;

    @GetMapping("/{id}/{currency}")
    public ResponseEntity<Book> findBook(
            @PathVariable Long id,
            @PathVariable String currency
    ){
        String port = environment.getProperty("local.server.port");

        return ResponseEntity.ok(new Book());
    }
}

package com.caioprogramador.bookservice.controller;

import com.caioprogramador.bookservice.model.Book;
import com.caioprogramador.bookservice.proxy.CambioProxy;
import com.caioprogramador.bookservice.repository.BookRepository;
import com.caioprogramador.bookservice.response.Cambio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@RestController
@RequestMapping("/book-service")
public class BookController {

    @Autowired
    private Environment environment;

    @Autowired
    private BookRepository repository;

    @Autowired
    private CambioProxy proxy;

    @GetMapping("/{id}/{currency}")
    public ResponseEntity<Book> findBook(
            @PathVariable Long id,
            @PathVariable String currency
    ){
        Book book = repository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));

        Cambio cambio = proxy.getCambio(book.getPrice(),"USD", currency).getBody();

         /*HashMap<String, String> params = new HashMap<>();
        params.put("amount", book.getPrice().toString());
        params.put("from", "USD");
        params.put("to",currency);

       ResponseEntity<Cambio> response = new RestTemplate().getForEntity(
                "http://localhost:8000/cambio-service/{amount}/{from}/{to}",
                Cambio.class,
                params
        );

        Cambio cambio = response.getBody();*/

        String port = environment.getProperty("local.server.port");
        book.setEnvironment(port);
        assert cambio != null;
        book.setPrice(cambio.getConvertedValue());
        book.setCurrency(currency);
        return ResponseEntity.ok(book);
    }
}

package com.caioprogramador.bookservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
@OpenAPIDefinition(
        info = @Info(
                title = "Book Service",
                description = "Book Service REST APIs Documentation",
                version = "0.0.1-SNAPSHOT",
                contact = @Contact(
                        name = "Caio Flôres",
                        email = "caio.florees2005@gmail.com",
                        url = "https://caioprogramador.pythonanywhere.com"
                )
        )
)
@SpringBootApplication
@EnableFeignClients
public class BookServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookServiceApplication.class, args);
    }

}

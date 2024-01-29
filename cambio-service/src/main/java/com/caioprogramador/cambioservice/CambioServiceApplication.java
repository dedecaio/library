package com.caioprogramador.cambioservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@OpenAPIDefinition(
        info = @Info(
                title = "Cambio Service",
                description = "Cambio Service REST APIs Documentation",
                version = "0.0.1-SNAPSHOT",
                contact = @Contact(
                        name = "Caio Flôres",
                        email = "caio.florees2005@gmail.com",
                        url = "https://caioprogramador.pythonanywhere.com"
                )
        )
)
@SpringBootApplication
public class CambioServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CambioServiceApplication.class, args);
    }

}

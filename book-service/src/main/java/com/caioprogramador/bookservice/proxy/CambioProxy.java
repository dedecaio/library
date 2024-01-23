package com.caioprogramador.bookservice.proxy;

import com.caioprogramador.bookservice.response.Cambio;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

@FeignClient(name = "cambio-service")
public interface CambioProxy {
    @GetMapping("/cambio-service/{amount}/{from}/{to}")
    public ResponseEntity<Cambio> getCambio(
            @PathVariable Double amount,
            @PathVariable String from,
            @PathVariable String to
    );
}

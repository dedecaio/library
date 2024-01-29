package com.caioprogramador.cambioservice.controller;

import com.caioprogramador.cambioservice.model.Cambio;
import com.caioprogramador.cambioservice.repository.CambioRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Tag(name = "Cambio Endpoint")
@RestController
@RequestMapping("/cambio-service")
public class CambioController {

    @Autowired
    private Environment environment;

    @Autowired
    private CambioRepository repository;
    @Operation(summary = "Get Cambio from currency")
    @GetMapping("/{amount}/{from}/{to}")
    public ResponseEntity<Cambio> getCambio(
            @PathVariable BigDecimal amount,
            @PathVariable String from,
            @PathVariable String to
            ){
        Cambio cambio = repository.findByFromAndTo(from, to);
        if (cambio == null) throw new RuntimeException("Currency Unsupported");

        String port = environment.getProperty("local.server.port");
        BigDecimal conversionFactor = cambio.getConversionFactor();
        BigDecimal convertedValue = conversionFactor.multiply(amount);
        cambio.setEnvironment(port);
        cambio.setConvertedValue(convertedValue.setScale(2, RoundingMode.CEILING));
        return ResponseEntity.ok(cambio);
    }
}

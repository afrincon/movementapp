package com.proyectocurso.seguimiento.controller;

import com.proyectocurso.seguimiento.model.DatosSuscriptor;
import com.proyectocurso.seguimiento.service.DatosSuscriptorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/datos-suscriptor")
public class DatosSuscriptorController {
    private final DatosSuscriptorService datosSuscriptorService;

    public DatosSuscriptorController(DatosSuscriptorService datosSuscriptorService) {
        this.datosSuscriptorService = datosSuscriptorService;
    }

    @GetMapping("/{id}")
    public Mono<DatosSuscriptor> obtenerDatosSuscriptorById(@PathVariable Integer id) {
        return datosSuscriptorService.obtenerDatosSuscriptorById(id);
    }
}

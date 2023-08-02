package com.proyectocurso.seguimiento.controller;

import com.proyectocurso.seguimiento.model.Suscripcion;
import com.proyectocurso.seguimiento.service.SuscripcionService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/suscripciones")
public class SuscripcionController {

    private final SuscripcionService suscripcionService;

    public SuscripcionController(SuscripcionService suscripcionService) {
        this.suscripcionService = suscripcionService;
    }

    @GetMapping("/")
    public Flux<Suscripcion> listarSuscripciones() {
        return suscripcionService.listarSuscripciones();
    }

    @GetMapping("/{id}")
    public Mono<Suscripcion> obtenerSuscripcionById(@PathVariable Integer id){
        return suscripcionService.obtenerSuscripcionById(id);
    }

     @PostMapping("/")
    public Mono<Suscripcion> guardarSuscripcion(@RequestBody Suscripcion suscripcion) {
        return suscripcionService.guardarSuscripcion(suscripcion);
     }

}

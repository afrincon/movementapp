package com.proyectocurso.seguimiento.controller;

import com.proyectocurso.seguimiento.dto.DTOSuscriptorNombreActivo;
import com.proyectocurso.seguimiento.model.Suscriptor;
import com.proyectocurso.seguimiento.service.SuscriptorService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/suscriptores")
public class SuscriptorController {

    private final SuscriptorService suscriptorService;

    public SuscriptorController(SuscriptorService suscriptorService) {
        this.suscriptorService = suscriptorService;
    }

    @GetMapping("/")
    public Flux<Suscriptor> obtenerSuscriptores() {
        return suscriptorService.obtenerSuscriptores();
    }

    @GetMapping("/{id}")
    public Mono<Suscriptor> obtenerSuscriptorById(@PathVariable Integer id) {
        return suscriptorService.obtenerSuscriptorById(id);
    }

    @PostMapping("/")
    public Mono<Suscriptor> guardarSuscriptor(@RequestBody Suscriptor suscriptor) {
        return suscriptorService.guardarSuscriptor(suscriptor);
    }

    @PutMapping("/{id}")
    public Mono<Suscriptor> actualizarSuscritor(@RequestBody Suscriptor suscriptor) {
        return null;
    }

    @DeleteMapping("/{id}")
    public Mono<Suscriptor> eliminarSuscritorById(@PathVariable Integer id) {
        return suscriptorService.eliminarSuscriptorById(id);
    }

    @DeleteMapping("/")
    public Mono<Void> eliminarSuscriptores() {
        return suscriptorService.eliminarSuscriptores();
    }

    @GetMapping("/suscriptores-activos")
    public Flux<Suscriptor> obtenerSuscriptoresActivos(){
        return suscriptorService.obtenerByEstado(Boolean.TRUE);
    }

    @GetMapping("/suscriptores-inactivos")
    public Flux<Suscriptor> obtenerSuscriptoresInactivos(){
        return suscriptorService.obtenerByEstado(Boolean.FALSE);
    }

    @PostMapping("/suscriptores-por-nombre-por-estado")
    public Flux<Suscriptor> obtenerSuscriptoresByNombreByEstado(@RequestBody DTOSuscriptorNombreActivo dtoSuscriptorNombreActivo) {
        return suscriptorService.obtenerByNombreAndEstado(dtoSuscriptorNombreActivo.nombre(), dtoSuscriptorNombreActivo.estado());
    }
}

package com.proyectocurso.seguimiento.service;

import com.proyectocurso.seguimiento.model.Suscripcion;
import com.proyectocurso.seguimiento.repository.SuscripcionRepositorio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SuscripcionService {
    private final Logger logger = LoggerFactory.getLogger(SuscriptorService.class);

    private final SuscripcionRepositorio suscripcionRepositorio;

    public SuscripcionService(SuscripcionRepositorio suscripcionRepositorio) {
        this.suscripcionRepositorio = suscripcionRepositorio;
    }

    public Flux<Suscripcion> listarSuscripciones() {
        return suscripcionRepositorio.findAll();
    }

    public Mono<Suscripcion> obtenerSuscripcionById(Integer id) {
        return suscripcionRepositorio.findById(id);
    }

    public Mono<Suscripcion> guardarSuscripcion(Suscripcion suscripcion){
        return suscripcionRepositorio.save(suscripcion);
    }
}

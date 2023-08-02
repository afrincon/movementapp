package com.proyectocurso.seguimiento.repository;

import com.proyectocurso.seguimiento.model.Suscriptor;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SuscriptorRepository extends R2dbcRepository<Suscriptor, Integer> {

    Flux<Suscriptor> findByEstado(Boolean estado);

    Flux<Suscriptor> findByNombreAndEstado(String nombre, Boolean estado);
}

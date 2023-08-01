package com.proyectocurso.seguimiento.repository;

import com.proyectocurso.seguimiento.model.Suscripcion;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuscripcionRepositorio extends R2dbcRepository<Suscripcion, Long> {
}

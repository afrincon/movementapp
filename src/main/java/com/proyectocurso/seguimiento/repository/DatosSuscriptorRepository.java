package com.proyectocurso.seguimiento.repository;

import com.proyectocurso.seguimiento.model.DatosSuscriptor;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatosSuscriptorRepository extends R2dbcRepository<DatosSuscriptor, Long> {
}

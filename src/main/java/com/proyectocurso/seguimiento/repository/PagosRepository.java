package com.proyectocurso.seguimiento.repository;

import com.proyectocurso.seguimiento.model.Pagos;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagosRepository extends R2dbcRepository<Pagos, Long> {
}

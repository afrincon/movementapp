package com.proyectocurso.seguimiento.service;

import com.proyectocurso.seguimiento.model.DatosSuscriptor;
import com.proyectocurso.seguimiento.repository.DatosSuscriptorRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Mono;

@Service
public class DatosSuscriptorService {

    private final DatosSuscriptorRepository datosSuscriptorRepository;

    public DatosSuscriptorService(DatosSuscriptorRepository datosSuscriptorRepository) {
        this.datosSuscriptorRepository = datosSuscriptorRepository;
    }

    public Mono<DatosSuscriptor> obtenerDatosSuscriptorById(@PathVariable Integer id) {
        return datosSuscriptorRepository.findById(id);
    }
}

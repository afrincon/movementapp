package com.proyectocurso.seguimiento.service;

import com.proyectocurso.seguimiento.model.Suscriptor;
import com.proyectocurso.seguimiento.repository.SuscriptorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SuscriptorService {

    private final Logger logger = LoggerFactory.getLogger(SuscriptorService.class);

    private final SuscriptorRepository suscriptorRepository;

    public SuscriptorService(SuscriptorRepository suscriptorRepository) {
        this.suscriptorRepository = suscriptorRepository;
    }

    public Flux<Suscriptor> obtenerSuscriptores() {
        return suscriptorRepository.findAll()
                .onErrorResume(throwable -> {
                    logger.error("Error al consultar todos los suscriptores", throwable);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Ningun suscriptor encontrado").getMostSpecificCause()));
    }

    public Mono<Suscriptor> obtenerSuscriptorById(Integer id) {
        return suscriptorRepository.findById(id)
                .onErrorResume(throwable -> {
                    logger.error("Error al consultar el suscriptor con id: " + id, throwable);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Suscriptor con id="+ id +" no encontrado").getMostSpecificCause()));
    }

    public Mono<Suscriptor> guardarSuscriptor(Suscriptor suscriptor){
        return suscriptorRepository.save(suscriptor);
    }

    public Mono<Suscriptor> eliminarSuscriptorById(Integer id) {
        return suscriptorRepository.findById(id)
                .flatMap(suscriptor ->
                        suscriptorRepository.deleteById(suscriptor.getIdSuscriptor())
                                .thenReturn(suscriptor))
                .onErrorResume(throwable -> {
                    logger.error("Error al borrar el suscriptor con id: " + id, throwable);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Suscriptor con id="+ id +" no encontrado").getMostSpecificCause()));
    }

    public Mono<Void> eliminarSuscriptores(){
        return suscriptorRepository.deleteAll()
                .onErrorResume(throwable -> {
                    logger.error("Error al consultar todos los suscriptores", throwable);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Suscriptores no borrados").getMostSpecificCause()));
    }

    public Flux<Suscriptor> obtenerByEstado(Boolean estado) {
        return suscriptorRepository.findByEstado(estado)
                .onErrorResume(throwable -> {
                    logger.error("Error al buscar suscriptores con activo: " + estado, throwable);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Suscriptores con activo=" + estado +" no encontrados").getMostSpecificCause()));
    }

    public Flux<Suscriptor> obtenerByNombreAndEstado(String nombre, Boolean estado) {
        return suscriptorRepository.findByNombreAndEstado(nombre,estado)
                .onErrorResume(throwable -> {
                    logger.error("Error al buscar suscritor por nombre: " + nombre + " y estado " + estado, throwable);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Suscriptores con nombre=" + nombre +" y estado=" + estado + " no encontrados").getMostSpecificCause()));
    }

    protected Mono<Boolean> validaIdentificacionExiste(Suscriptor suscriptor) {
        return Mono.just(true);
    }
}

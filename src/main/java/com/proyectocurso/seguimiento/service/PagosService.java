package com.proyectocurso.seguimiento.service;

import com.proyectocurso.seguimiento.model.Pagos;
import com.proyectocurso.seguimiento.repository.PagosRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PagosService {

    private final Logger logger = LoggerFactory.getLogger(PagosService.class);

    private final PagosRepository pagosRepository;

    public PagosService(PagosRepository pagosRepository) {
        this.pagosRepository = pagosRepository;
    }

    public Flux<Pagos> consultarPagos() {
        return pagosRepository.findAll();
    }

    public Mono<Pagos> consultarPagoById(Integer id) {
        return pagosRepository.findById(id);
    }

    public Mono<Pagos> guardarPago(Pagos pago) {
        return pagosRepository.save(pago);
    }
}

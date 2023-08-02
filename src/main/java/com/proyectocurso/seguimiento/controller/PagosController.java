package com.proyectocurso.seguimiento.controller;

import com.proyectocurso.seguimiento.model.Pagos;
import com.proyectocurso.seguimiento.service.PagosService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/pagos")
public class PagosController {

    private final PagosService pagosService;

    public PagosController(PagosService pagosService) {
        this.pagosService = pagosService;
    }

    @GetMapping("/")
    public Flux<Pagos> consultarPagos() {
        return pagosService.consultarPagos();
    }

    @GetMapping("/{id}")
    public Mono<Pagos> consultarPagoByID(@PathVariable Integer id) {
        return pagosService.consultarPagoById(id);
    }

    @PostMapping("/")
    public Mono<Pagos> guardarPago(@RequestBody Pagos pago) {
        return pagosService.guardarPago(pago);
    }
}

package com.proyectocurso.seguimiento.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@AllArgsConstructor
public class Pagos {
    @Id
    Integer idPago;
    Integer idSuscriptor;
    Integer valorPago;
    Date fechaPago;
}

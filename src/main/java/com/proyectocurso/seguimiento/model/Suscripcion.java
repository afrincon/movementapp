package com.proyectocurso.seguimiento.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Suscripcion implements AccionesSuscripcion {
    @Id
    private Long idSuscipcion;
    private Long idSuscriptor;
    private Date fechaInicio;
    private Date fechaFinalizacion;
    private Boolean estado;
}

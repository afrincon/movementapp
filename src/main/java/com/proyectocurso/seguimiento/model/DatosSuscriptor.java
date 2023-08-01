package com.proyectocurso.seguimiento.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DatosSuscriptor {
    @Id
    private Long id;
    private Long idSuscriptor;
    private Date fecha;
    private Float peso;
    public Integer altura;
}

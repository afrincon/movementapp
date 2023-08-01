package com.proyectocurso.seguimiento.controller;

import com.proyectocurso.seguimiento.model.Suscriptor;
import com.proyectocurso.seguimiento.service.SuscriptorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static reactor.core.publisher.Mono.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@TestPropertySource(locations = "classpath:application-test.properties")
@ExtendWith(MockitoExtension.class)
class SuscriptorControllerTest {

    @InjectMocks
    private SuscriptorController suscriptorController;

    @Mock
    SuscriptorService suscriptorService = mock(SuscriptorService.class);

    @Test
    void obtenerSuscriptores() {
    }

    @Test
    void obtenerSuscriptorById() {
        Suscriptor suscriptorTest = new Suscriptor(1, "Pepito Perez", "1234567",
                "Avenida siempreviva 123", "3154789632", true);
        when(suscriptorService.obtenerSuscriptorById(suscriptorTest.getIdSuscriptor()))
                .thenReturn(Mono.just(suscriptorTest));



        Suscriptor suscriptorResultado = suscriptorController.obtenerSuscriptorById(suscriptorTest.getIdSuscriptor())
                .block();
        assertEquals(suscriptorTest, suscriptorResultado);

    }

    @Test
    void guardarSuscriptor() {
    }

    @Test
    void actualizarSuscritor() {
    }

    @Test
    void eliminarSuscritorById() {
    }

    @Test
    void eliminarSuscriptores() {
    }
}
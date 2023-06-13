package com.heinsohn.tienda.controller;

import com.heinsohn.tienda.dto.ComicDto;
import com.heinsohn.tienda.exception.GestionarComicException;
import com.heinsohn.tienda.exception.TiendaComicException;
import com.heinsohn.tienda.interfaz.IConsultarComicTamanioNombre;
import com.heinsohn.tienda.interfaz.IGestionarComic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;

class GestionarComicTallerControllerTest {

    @InjectMocks
    private GestionarComicTallerController gestionarComicTallerController;
    @Mock
    private IConsultarComicTamanioNombre gestiConsultarComicTamanioNombre;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void whenConsultarComicTamanioNombreSuccess() throws GestionarComicException {
        ResponseEntity<?> response = gestionarComicTallerController.getConsultarComicTamanioNombre((short) 8);
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

}
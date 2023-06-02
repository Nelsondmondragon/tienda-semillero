package com.heinsohn.tienda.controller;

import com.heinsohn.tienda.dto.ComicDto;
import com.heinsohn.tienda.exception.TiendaComicException;
import com.heinsohn.tienda.interfaz.IGestionarComic;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class GestionarComicControllerTest {

    @InjectMocks
    private GestionarComicController gestionarComicController;

    @Mock
    private IGestionarComic gestionarService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void whenCreateComicGivenNewComicThenResponseSuccess() throws TiendaComicException {
        ResponseEntity<?> response = gestionarComicController.createComic(new ComicDto());
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void findById() {
    }

    @Test
    void findByAll() {
    }

    @Test
    void deleteById() {
    }
}
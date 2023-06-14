package com.heinsohn.tienda.controller;

import com.heinsohn.tienda.exception.GestionarComicException;
import com.heinsohn.tienda.exception.TiendaComicException;
import com.heinsohn.tienda.interfaz.ICompraComic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;


class CompraComicControllerTest {
    @InjectMocks
    private CompraComicController compraComicController;
    @Mock
    private ICompraComic compraComic;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void whenSuccessfulPurchase() throws TiendaComicException {
        ResponseEntity<?> response = compraComicController.compraComic(6L, 5);
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
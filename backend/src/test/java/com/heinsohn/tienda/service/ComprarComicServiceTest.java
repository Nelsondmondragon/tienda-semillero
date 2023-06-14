package com.heinsohn.tienda.service;

import com.heinsohn.tienda.enums.EstadoEnum;
import com.heinsohn.tienda.exception.CompraComicException;
import com.heinsohn.tienda.exception.GestionarComicException;
import com.heinsohn.tienda.exception.TiendaComicException;
import com.heinsohn.tienda.model.Comic;
import com.heinsohn.tienda.repository.ComicRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class ComprarComicServiceTest {

    @InjectMocks
    private ComprarComicService comprarComicService;

    @Mock
    private ComicRepository comicRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }




    @Test
    public void whenComicStateInactivo() throws TiendaComicException {
        Comic comic = new Comic();
        comic.setEstadoEnum(EstadoEnum.INACTIVO);
        Optional<Comic> comic1 = Optional.of(comic);
        when(comicRepository.findById(
                any())).thenReturn(comic1);

        CompraComicException exception = assertThrows(CompraComicException.class,
                () -> comprarComicService.comprarComic(5L, 6));
        assertNotNull(exception);
    }

    @Test
    public void whenComicQuantitiesGreater() throws TiendaComicException {
        Comic comic = new Comic();
        comic.setEstadoEnum(EstadoEnum.ACTIVO);
        comic.setCantidad(4);
        Optional<Comic> comic1 = Optional.of(comic);
        when(comicRepository.findById(
                any())).thenReturn(comic1);

        CompraComicException exception = assertThrows(CompraComicException.class,
                () -> comprarComicService.comprarComic(5L, 6));
        assertNotNull(exception);
    }

    @Test
    public void whenComicPurchaseSuccess() throws TiendaComicException {
        Comic comic = new Comic();
        comic.setId(1L);
        comic.setNombre("Test");
        comic.setEstadoEnum(EstadoEnum.ACTIVO);
        comic.setCantidad(7);
        Optional<Comic> comic1 = Optional.of(comic);
        when(comicRepository.findById(
                any())).thenReturn(comic1);

        String nombre = this.comprarComicService.comprarComic(1L, 4);
        assertNotNull(nombre);
        assertEquals("Test", nombre);
    }

    @Test
    public void whenComicPurchaseSuccessQuantityZero() throws TiendaComicException {
        Comic comic = new Comic();
        comic.setId(1L);
        comic.setNombre("Test");
        comic.setEstadoEnum(EstadoEnum.ACTIVO);
        comic.setCantidad(7);
        Optional<Comic> comic1 = Optional.of(comic);
        when(comicRepository.findById(
                any())).thenReturn(comic1);

        String nombre = this.comprarComicService.comprarComic(1L, 7);
        assertNotNull(nombre);
        assertEquals("Test", nombre);
    }
}
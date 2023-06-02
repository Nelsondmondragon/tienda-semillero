package com.heinsohn.tienda.model;

import com.heinsohn.tienda.enums.EstadoEnum;
import com.heinsohn.tienda.enums.TematicaEnum;
import com.heinsohn.tienda.exception.GestionarComicException;
import com.heinsohn.tienda.service.TallerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class CreateComicTest {

    private static final String NOMBRE = "Dragon Ball number ";
    private static final String EDITORIAL = "Editorial number ";
    private static final String COLECCION = "Coleccion number 1";
    private static final Integer NUMEROPAGINAS = 1;
    private static final Double PRECIO = 234234234D;
    private static final String AUTORES = "Autor 1";
    private static final Boolean COLOR = true;
    private static final Integer CANTIDAD = 1;

    @InjectMocks
    private TallerService tallerService;


    List<Comic> comics;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        comics = Arrays.asList(
                generateComic(TematicaEnum.AVENTURAS, EstadoEnum.ACTIVO, 0),
                generateComic(TematicaEnum.BELICO, EstadoEnum.INACTIVO, 1),
                generateComic(TematicaEnum.CIENCIA_FICCION, EstadoEnum.ACTIVO, 2),
                generateComic(TematicaEnum.DEPORTIVO, EstadoEnum.INACTIVO, 3),
                generateComic(TematicaEnum.FANTASTICO, EstadoEnum.ACTIVO, 4),
                generateComic(TematicaEnum.DEPORTIVO, EstadoEnum.INACTIVO, 5),
                generateComic(TematicaEnum.CIENCIA_FICCION, EstadoEnum.ACTIVO, 6),
                generateComic(TematicaEnum.AVENTURAS, EstadoEnum.INACTIVO, 7),
                generateComic(TematicaEnum.CIENCIA_FICCION, EstadoEnum.ACTIVO, 8),
                generateComic(TematicaEnum.AVENTURAS, EstadoEnum.ACTIVO, 9)
        );

    }

    @Test
    void generarExeption() {
        Exception exception = assertThrows(Exception.class,
                () -> tallerService.metodoExeption(comics));

        System.out.println(exception.getMessage());
    }

    @Test
    void comprobarEstadoComics() {
        getListIsActivo(comics).forEach(System.out::println);
        System.out.println("/////////////////////////////");
        getListIsInactivo(comics).forEach(System.out::println);
    }

    private Comic generateComic(TematicaEnum tematicaEnum, EstadoEnum estadoEnum, int i) {
        return new Comic(1L + i, NOMBRE + i, EDITORIAL + i, tematicaEnum,
                COLECCION + i, NUMEROPAGINAS + i, new BigDecimal(PRECIO + i),
                AUTORES + i, COLOR, LocalDate.now(), estadoEnum, CANTIDAD + i);
    }


    private List<Comic> getListIsActivo(List<Comic> comics) {
        return comics.stream().filter(comic -> comic.getEstadoEnum().equals(EstadoEnum.ACTIVO))
                .collect(Collectors.toList());
    }

    private List<Comic> getListIsInactivo(List<Comic> comics) {
        return comics.stream().filter(comic -> comic.getEstadoEnum().equals(EstadoEnum.INACTIVO))
                .collect(Collectors.toList());
    }

}
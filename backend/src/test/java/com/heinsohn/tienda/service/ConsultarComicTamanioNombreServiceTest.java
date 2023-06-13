package com.heinsohn.tienda.service;

import com.heinsohn.tienda.dto.SalidaDto;
import com.heinsohn.tienda.exception.GestionarComicException;
import com.heinsohn.tienda.repository.ComicRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class ConsultarComicTamanioNombreServiceTest {
    @InjectMocks
    private ConsultarComicTamanioNombreService consultarComicTamanioNombreService;

    @Mock
    private ComicRepository comicRepository;


    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void whenThrowsExceptionMaxLengthCharacters() {
        GestionarComicException exception = assertThrows(GestionarComicException.class,
                () -> consultarComicTamanioNombreService.consultarComicTamanioNombre((short) 9));

        assertNotNull(exception);
        assertInstanceOf(GestionarComicException.class, exception);
    }


    @Test
    void whenConsultarComicTamanioNombreThenResponseSuccess() throws GestionarComicException {
        List<String> comicMayor = new ArrayList<>(Arrays.asList("Batman", "Hercules"));
        List<String> comicMenor = new ArrayList<>(Arrays.asList("Thor", "Hulk"));
        when(comicRepository.consultarComicTamanioNombreMayor(any())).thenReturn(comicMayor);
        when(comicRepository.consultarComicTamanioNombreMenor(any())).thenReturn(comicMenor);
        SalidaDto salidaDto = this.consultarComicTamanioNombreService.consultarComicTamanioNombre((short) 5);
        assertNotNull(salidaDto.getComicsNoSuperanTamanio());
        assertNotNull(salidaDto.getComicsSuperanTamanio());


    }


}
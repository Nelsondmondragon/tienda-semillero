package com.heinsohn.tienda.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import com.heinsohn.tienda.dto.ConsultaNombrePrecioDto;
import com.heinsohn.tienda.exception.GestionarComicException;
import com.heinsohn.tienda.exception.TiendaComicException;
import com.heinsohn.tienda.model.Comic;
import com.heinsohn.tienda.repository.ComicRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;


class GestionarComicServiceTest {

    @InjectMocks
    private GestionarComicService gestionarComicService;

    @Mock
    private ComicRepository comicRepository;

    @Mock
    private ModelMapper modelMapper;


    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void whenConsultarNombrePrecioComicGivenGestionarComicException_thenError() throws TiendaComicException {
//        Mockito.doThrow()
        GestionarComicException exception = assertThrows(GestionarComicException.class,
                () -> gestionarComicService.consultarNombrePrecioComic(-1L));

        assertNotNull(exception);
//        assertInstanceOf(GestionarComicException.class, exception);
    }


    @Test
    public void whenConsultarNombrePrecioComic_givenGestionarComicException_thenFail() throws GestionarComicException {
        doThrow(GestionarComicException.class).when(comicRepository).obtenerNombreYPrecio(any());
        GestionarComicException exception = assertThrows(GestionarComicException.class, () -> gestionarComicService.consultarNombrePrecioComic(1L));
        assertNotNull(exception);
        assertTrue(exception.getMessage().contains("El idComic "));
    }


    @Test
    public void whenConsultarNombrePrecioComicGivenGestionarComicThenResponseSuccess() throws TiendaComicException {
        ConsultaNombrePrecioDto consultaNombrePrecioDto = new ConsultaNombrePrecioDto();
        consultaNombrePrecioDto.setNombre("Test");
        consultaNombrePrecioDto.setPrecio(new BigDecimal(2323));
        when(comicRepository.obtenerNombreYPrecio(
                any())).thenReturn(consultaNombrePrecioDto);

        ConsultaNombrePrecioDto consultaNombrePrecioDto1 = this.gestionarComicService.consultarNombrePrecioComic(1L);
        assertNotNull(consultaNombrePrecioDto1);
    }
}
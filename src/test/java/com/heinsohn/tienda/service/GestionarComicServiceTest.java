package com.heinsohn.tienda.service;

import com.heinsohn.tienda.dto.ConsultaNombrePrecioDto;
import com.heinsohn.tienda.exception.GestionarComicException;
import com.heinsohn.tienda.exception.TiendaComicException;
import com.heinsohn.tienda.repository.ComicRepository;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

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
        assertInstanceOf(GestionarComicException.class, exception);
    }


    @Test
    public void whenConsultarNombrePrecioComicGivenGestionarComicException_thenFail() throws TiendaComicException {
        Mockito.doThrow(GestionarComicException.class).when(comicRepository)
                .obtenerNombrePrecio(ArgumentMatchers.any());

//       / assertThrows(GestionarComicException.class, this.gestionarComicService
//                .consultarNombrePrecioComic(1L));
    }


    @Test
    public void whenConsultarNombrePrecioComicGivenGestionarComicThenResponseSuccess() throws TiendaComicException {
        ConsultaNombrePrecioDto consultaNombrePrecioDto = new ConsultaNombrePrecioDto();
        consultaNombrePrecioDto.setNombre("Test");
        consultaNombrePrecioDto.setPrecio(new BigDecimal(2323));
        Mockito.when(comicRepository.obtenerNombrePrecio(
                ArgumentMatchers.any())).thenReturn(consultaNombrePrecioDto);

        ConsultaNombrePrecioDto consultaNombrePrecioDto1 = this.gestionarComicService.consultarNombrePrecioComic(1L);
        assertNotNull(consultaNombrePrecioDto1);
    }
}
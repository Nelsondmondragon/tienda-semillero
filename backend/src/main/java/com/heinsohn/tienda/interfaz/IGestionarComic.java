package com.heinsohn.tienda.interfaz;

import com.heinsohn.tienda.dto.ComicDto;
import com.heinsohn.tienda.dto.ConsultaNombrePrecioDto;
import com.heinsohn.tienda.exception.GestionarComicException;
import com.heinsohn.tienda.exception.TiendaComicException;

import java.io.IOException;
import java.util.List;

public interface IGestionarComic {
    void createComic(ComicDto comicDto) throws TiendaComicException, GestionarComicException;

    ComicDto findById(Long idComic) throws TiendaComicException;


    List<ComicDto> findAll() throws TiendaComicException;

    void deleteById(Long idComic) throws GestionarComicException;

    ConsultaNombrePrecioDto consultarNombrePrecioComic(Long idComic) throws TiendaComicException, GestionarComicException;

}

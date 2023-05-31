package com.heinsohn.tienda.interfaz;

import com.heinsohn.tienda.dto.ComicDto;

import java.io.IOException;
import java.util.List;

public interface IGestionarComic {
    void createComic(ComicDto comicDto) throws IOException;

    ComicDto findById(Long idComic) throws IOException;


    List<ComicDto> findAll() throws IOException;

    void deleteById(Long idComic) throws IOException;
}

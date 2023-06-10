package com.heinsohn.tienda.controller;

import com.heinsohn.tienda.dto.ComicDto;
import com.heinsohn.tienda.dto.SalidaDto;
import com.heinsohn.tienda.exception.GestionarComicException;
import com.heinsohn.tienda.exception.TiendaComicException;
import com.heinsohn.tienda.interfaz.IConsultarComicTamanioNombre;
import com.heinsohn.tienda.interfaz.IGestionarComic;
import com.heinsohn.tienda.util.Util;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("tiendacomic")
@RequiredArgsConstructor
public class GestionarComicController extends Util {


    private final IGestionarComic gestionarComic;

    private final static Logger LOG = LogManager.getLogger(GestionarComicController.class);


    @PostMapping("")
    public ResponseEntity<?> createComic(@RequestBody ComicDto comicDto) throws TiendaComicException {
        LOG.info("Inicia createComic() con data  {}", comicDto.toString());
        this.gestionarComic.createComic(comicDto);
        String response = "Se ha creado el comic exitosamente";
        LOG.info("Finaliza createComic() con data  {}", response);
        return buildResponse(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long idComic) throws TiendaComicException {

        return buildResponse(this.gestionarComic.findById(idComic));
    }


    @GetMapping("")
    public ResponseEntity<?> findByAll() throws TiendaComicException {
        return buildResponse(this.gestionarComic.findAll());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long idComic) throws GestionarComicException {
        this.gestionarComic.deleteById(idComic);
        String response = "El comic " + idComic + " ha sido eliminado";

        return buildResponse(response);
    }


}

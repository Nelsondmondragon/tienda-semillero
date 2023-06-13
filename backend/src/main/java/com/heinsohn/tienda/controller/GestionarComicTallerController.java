package com.heinsohn.tienda.controller;

import com.heinsohn.tienda.dto.SalidaDto;
import com.heinsohn.tienda.exception.GestionarComicException;
import com.heinsohn.tienda.interfaz.IConsultarComicTamanioNombre;
import com.heinsohn.tienda.util.Util;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * Clase que representa los servicios REST ComicTaller.
 *
 * @author Nelson Cortes.
 */
@RestController
@RequestMapping("tiendacomic")
@RequiredArgsConstructor
public class GestionarComicTallerController extends Util {

    private final IConsultarComicTamanioNombre consultarComicTamanioNombre;

    private final static Logger LOG = LogManager.getLogger(GestionarComicTallerController.class);


    /**
     * <p>
     * Metodo que permite obtener dos listas de comics.
     * </p>
     *
     * @param lengthComic indica la longitud de los nombres de comic.
     * @return devulve una lista con los nombres de los comics que sean iguales o superen comicLength y una
     * lista con los que no superen dicha longitud.
     * @throws GestionarComicException
     */
    @GetMapping("taller")
    public ResponseEntity<?> getConsultarComicTamanioNombre(@RequestParam(name = "length") Short lengthComic) throws GestionarComicException {
        LOG.info("Inicia getConsultarComicTamanioNombre() con data  {}", lengthComic);
        SalidaDto salidaDto = this.consultarComicTamanioNombre
                .consultarComicTamanioNombre(lengthComic);
        LOG.info("Finaliza getConsultarComicTamanioNombre() con data  {}", salidaDto);
        return buildResponseCustom(salidaDto);
    }

}

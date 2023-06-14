package com.heinsohn.tienda.controller;


import com.heinsohn.tienda.exception.TiendaComicException;
import com.heinsohn.tienda.interfaz.ICompraComic;
import com.heinsohn.tienda.util.Util;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("compra")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class CompraComicController extends Util {

    private final ICompraComic compraComicService;

    private final static Logger LOG = LogManager.getLogger(CompraComicController.class);

    @GetMapping("/{idComic}")
    public ResponseEntity<?> compraComic(@PathVariable Long idComic,
                                         @RequestParam Integer cantidad) throws TiendaComicException {
//        LOG.info("Inicia createComic() con data  {}", comicDto.toString());
        String response = "La compra del comic " +
                this.compraComicService.comprarComic(idComic, cantidad)
                + "  fue exitosa";
//        LOG.info("Finaliza createComic() con data  {}", response);
        return buildResponse(response);
    }

}

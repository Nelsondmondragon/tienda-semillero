package com.heinsohn.tienda.service;

import com.heinsohn.tienda.dto.ComicCompraDto;
import com.heinsohn.tienda.enums.EstadoEnum;
import com.heinsohn.tienda.enums.TICOEnum;
import com.heinsohn.tienda.exception.CompraComicException;
import com.heinsohn.tienda.interfaz.ICompraComic;
import com.heinsohn.tienda.model.Comic;
import com.heinsohn.tienda.repository.ComicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
@RequiredArgsConstructor
public class ComprarComicService implements ICompraComic {

    private final ComicRepository comicRepository;

    @Override
    public String comprarComic(Long idComic, Integer cantidad) throws CompraComicException {

        Comic comic = this.comicRepository.findById(idComic)
                .orElseThrow(() -> new CompraComicException(TICOEnum.TICO_0009));

        if (comic.getEstadoEnum().equals(EstadoEnum.INACTIVO)) {
            throw new CompraComicException(TICOEnum.TICO_0007);
        }
        if (cantidad > comic.getCantidad()) {
            throw new CompraComicException(TICOEnum.TICO_0008, comic.getCantidad().toString());
        }

        if (cantidad.equals(comic.getCantidad())) {
            comic.setEstadoEnum(EstadoEnum.INACTIVO);
        }
        comic.setFechaVenta(LocalDate.now());
        comic.setCantidad(comic.getCantidad() - cantidad);
        this.comicRepository.save(comic);
        return comic.getNombre();
    }
}

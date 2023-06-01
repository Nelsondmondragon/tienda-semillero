package com.heinsohn.tienda.service;

import com.heinsohn.tienda.controller.GestionarComicController;
import com.heinsohn.tienda.dto.ComicDto;
import com.heinsohn.tienda.dto.ConsultaNombrePrecioDto;
import com.heinsohn.tienda.enums.TICOEnum;
import com.heinsohn.tienda.exception.GestionarComicException;
import com.heinsohn.tienda.exception.TiendaComicException;
import com.heinsohn.tienda.interfaz.IGestionarComic;
import com.heinsohn.tienda.model.Comic;
import com.heinsohn.tienda.repository.ComicRepository;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GestionarComicService implements IGestionarComic {


    private final static Logger LOG = LogManager.getLogger(GestionarComicService.class);

    private final ComicRepository comicRepository;


    private final ModelMapper modelMapper;

    @Override
    public void createComic(ComicDto comicDto) throws TiendaComicException, GestionarComicException {
        LOG.info("Inicia createComic() con data  {}", comicDto.toString());

        if (comicDto != null && comicDto.getNombre().length() > 50) {
            LOG.error("Se ha presentado una excepcion GestionarComicException con mensaje {} ", TICOEnum.TICO_0005);

            throw new GestionarComicException(TICOEnum.TICO_0005);
        }

        Comic comic = modelMapper.map(comicDto, Comic.class);
        Comic save = this.comicRepository.save(comic);

        LOG.info("Finaliza metodo createComic() con id {}", save.getId());

    }

    @Override
    public ComicDto findById(Long idComic) throws TiendaComicException {
        Optional<Comic> comic = this.comicRepository.findById(idComic);
        if (comic.isPresent()) {
            return modelMapper.map(comic, ComicDto.class);
        }
        return null;
    }

    @Override
    public List<ComicDto> findAll() throws TiendaComicException {
        return this.comicRepository.findAll().stream().map(comic ->
                this.modelMapper.map(comic, ComicDto.class)
        ).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long idComic) throws GestionarComicException {
        if (idComic <= 0) {
            throw new GestionarComicException(TICOEnum.TICO_0001, idComic.toString(), "1", "5", "8");
        }
        this.comicRepository.deleteById(idComic);
    }

    @Override
    public ConsultaNombrePrecioDto consultarNombrePrecioComic(Long idComic) throws TiendaComicException, GestionarComicException {
        if (idComic <= 0) {
            throw new GestionarComicException(TICOEnum.TICO_0001, idComic.toString(), "1", "5", "8");
        }
        return comicRepository.obtenerNombrePrecio(idComic);

    }
}

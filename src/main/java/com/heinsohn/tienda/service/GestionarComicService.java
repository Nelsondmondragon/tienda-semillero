package com.heinsohn.tienda.service;

import com.heinsohn.tienda.dto.ComicDto;
import com.heinsohn.tienda.enums.TICOEnum;
import com.heinsohn.tienda.exception.GestionarComicException;
import com.heinsohn.tienda.exception.TiendaComicException;
import com.heinsohn.tienda.interfaz.IGestionarComic;
import com.heinsohn.tienda.model.Comic;
import com.heinsohn.tienda.repository.ComicRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GestionarComicService implements IGestionarComic {

    private final ComicRepository comicRepository;


    private final ModelMapper modelMapper;

    @Override
    public void createComic(ComicDto comicDto) throws TiendaComicException, GestionarComicException {
        if (comicDto != null && comicDto.getNombre().length() > 50) {
            throw new GestionarComicException(TICOEnum.TICO_0005);
        }

        Comic comic = modelMapper.map(comicDto, Comic.class);
        this.comicRepository.save(comic);
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
}

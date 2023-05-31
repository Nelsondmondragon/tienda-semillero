package com.heinsohn.tienda.service;

import com.heinsohn.tienda.dto.ComicDto;
import com.heinsohn.tienda.interfaz.IGestionarComic;
import com.heinsohn.tienda.model.Comic;
import com.heinsohn.tienda.repository.ComicRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GestionarComicService implements IGestionarComic {

    private final ComicRepository comicRepository;


    private final ModelMapper modelMapper;

    @Override
    public void createComic(ComicDto comicDto) throws IOException {
        Comic comic = modelMapper.map(comicDto, Comic.class);
        this.comicRepository.save(comic);
    }

    @Override
    public ComicDto findById(Long idComic) throws IOException {
        return this.comicRepository.findById(idComic)
                .map(comic -> this.modelMapper.map(comic, ComicDto.class))
                .orElseThrow(() -> new IOException("No existe comic"));
    }

    @Override
    public List<ComicDto> findAll() throws IOException {
        return this.comicRepository.findAll().stream().map(comic ->
                this.modelMapper.map(comic, ComicDto.class)
        ).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long idComic) throws IOException {
        this.comicRepository.deleteById(idComic);
    }
}

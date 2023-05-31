package com.heinsohn.tienda.controller;

import com.heinsohn.tienda.dto.ComicDto;
import com.heinsohn.tienda.interfaz.IGestionarComic;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("tiendacomic")
@RequiredArgsConstructor
public class GestionarComicController {


    private final IGestionarComic gestionarComic;

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody ComicDto comicDto) throws IOException {
        this.gestionarComic.createComic(comicDto);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long idComic) throws IOException {

        return new ResponseEntity<>(this.gestionarComic.findById(idComic), HttpStatus.OK);
    }


    @GetMapping("")
    public ResponseEntity<?> findByAll() throws IOException {
        return new ResponseEntity<>(this.gestionarComic.findAll(), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long idComic) throws IOException {
        this.gestionarComic.deleteById(idComic);
        return ResponseEntity.noContent().build();
    }


}

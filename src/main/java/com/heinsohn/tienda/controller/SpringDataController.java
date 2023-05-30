package com.heinsohn.tienda.controller;

import com.heinsohn.tienda.dto.ConsultaNombrePrecioDto;
import com.heinsohn.tienda.enums.EstadoEnum;
import com.heinsohn.tienda.model.Comic;
import com.heinsohn.tienda.repository.ComicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
//@RequiredArgsConstructor
@RequestMapping("/test")

public class SpringDataController {

    @Autowired
    private ComicRepository comicRepository;


    @GetMapping("/clase3")
    public String test3() {

        PageRequest page = PageRequest.of(1, 6, Sort.by("nombre").ascending());
        Page<String> allNamesComics = this.comicRepository.findAllNamesComics(page);

        List<String> content = allNamesComics.getContent();

        System.out.println(Arrays.toString(content.toArray()));
        Object[][] objects = this.comicRepository.obtenerQueryNative(1L);
        String o = (String) objects[0][0];
        ConsultaNombrePrecioDto consultaNombrePrecioDto = this.comicRepository.obtenerNombrePrecio(1L);
        return "";
    }


    @GetMapping("/clase2")
    public String test2() {
//        List<Comic> allNamesComics = this.comicRepository.findAllNamesComics();
        Comic comic = this.comicRepository.obtenerComicPorId(1L);
        List<Comic> comics = this.comicRepository.obtenerComicCharacterAndEstadoEnum("at", EstadoEnum.ACTIVO);
        Comic comic1 = this.comicRepository.consultarComicPorNombre("Bat");
        Comic comic2 = this.comicRepository.actualizarEstadoComicPorId(EstadoEnum.INACTIVO,
                7L);
        Comic comic3 = this.comicRepository.actualizarEstadoComicPorIdS(EstadoEnum.ACTIVO, Arrays.asList(1L, 3L));


        this.comicRepository.eliminarComicPorEstado(EstadoEnum.INACTIVO);
        return "";
    }


    @GetMapping("")
    public String test() {
        Optional<Comic> comic = Optional.empty();
        List<Comic> comics;
        this.comicRepository.findById(66L).get();
        try {

            long count = this.comicRepository.count();
            boolean b = this.comicRepository.existsById(1L);

            comic = this.comicRepository.findById(1L);
            if (comic.isPresent()) {
                System.out.println(comic.get().getId());
                System.out.println(comic.get().getNombre());
            }

            comics = this.comicRepository.findAll();


            Comic comicNuevo = new Comic();

            comicNuevo.setNombre("Batman");
            comicNuevo.setCantidad(20);
            comicNuevo.setEditorial("DC");
            comicNuevo.setColeccion("Batman");
            comicNuevo.setNumeroPaginas(100);
            comicNuevo.setPrecio(new BigDecimal(1000));
            Comic save = comicRepository.save(comicNuevo);


            // Update registro existente base de datos.

            this.comicRepository.findById(5L).ifPresent(comic1 -> {
                comic1.setNombre("Change name test 2");
                comicRepository.save(comicNuevo);
            });

            // DeleteById nuevo registro
            comicRepository.deleteById(save.getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}

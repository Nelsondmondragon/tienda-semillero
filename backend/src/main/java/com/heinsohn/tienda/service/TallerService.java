package com.heinsohn.tienda.service;

import com.heinsohn.tienda.enums.EstadoEnum;
import com.heinsohn.tienda.interfaz.ITaller;
import com.heinsohn.tienda.model.Comic;

import java.util.List;

public class TallerService implements ITaller {


    @Override
    public List<Comic> metodoExeption(List<Comic> comics) throws Exception {
        throw new Exception("Se ha detectado que de\n" +
                comics.size() + " comics se encontraron que " +
                size(comics, EstadoEnum.ACTIVO)
                + "  se encuentran activos y \n" +
                size(comics, EstadoEnum.INACTIVO) +
                " inactivos. \nLos comics inactivos son: "
                + names(comics)
        );
//        return null;
    }

    private String names(List<Comic> comics) {
        return comics.stream().filter(comic -> comic.getEstadoEnum().equals(EstadoEnum.INACTIVO))
                .map(Comic::getNombre).reduce("", (acomulador, elemento) -> acomulador + "-" + elemento);
    }

    private int size(List<Comic> comics, EstadoEnum estadoEnum) {
        return (int) comics.stream().filter(comic -> comic.getEstadoEnum().equals(estadoEnum)).count();
    }
}

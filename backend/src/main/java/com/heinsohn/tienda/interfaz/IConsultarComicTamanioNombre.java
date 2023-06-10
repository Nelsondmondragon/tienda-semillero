package com.heinsohn.tienda.interfaz;

import com.heinsohn.tienda.dto.SalidaDto;
import com.heinsohn.tienda.exception.GestionarComicException;
import com.heinsohn.tienda.exception.TiendaComicException;

public interface IConsultarComicTamanioNombre {

    SalidaDto consultarComicTamanioNombre(Short lengthComic) throws GestionarComicException;

}

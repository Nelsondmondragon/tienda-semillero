package com.heinsohn.tienda.service;

import com.heinsohn.tienda.dto.ComicNombreDto;
import com.heinsohn.tienda.dto.SalidaDto;
import com.heinsohn.tienda.enums.TICOEnum;
import com.heinsohn.tienda.exception.GestionarComicException;
import com.heinsohn.tienda.exception.TiendaComicException;
import com.heinsohn.tienda.interfaz.IConsultarComicTamanioNombre;
import com.heinsohn.tienda.repository.ComicRepository;
import lombok.RequiredArgsConstructor;
import org.omg.PortableInterceptor.SUCCESSFUL;
import org.springframework.stereotype.Service;

/**
 * Clase que representa el servicio de ComicTaminioNombre.
 * @author Nelson Cortes.
 */
@Service
@RequiredArgsConstructor
public class ConsultarComicTamanioNombreService implements IConsultarComicTamanioNombre {

    private final ComicRepository comicRepository;

    private static final String SUCCESS = "Comics procesados exitosamente";
    /**
     * <p>
     *     Metodo que permite obtener dos listas de comics.
     * </p>
     *
     * @param lengthComic indica la longitud de los nombres de comic.
     * @return devulve un dto con una lista con los nombres de los comics que sean iguales o superen comicLength y una
     * lista con los que no superen dicha longitud.
     * @throws GestionarComicException
     */
    @Override
    public SalidaDto consultarComicTamanioNombre(Short lengthComic) throws GestionarComicException {
        if (lengthComic>8) {
            throw new GestionarComicException(TICOEnum.TICO_0006,"8");
        }

        SalidaDto salidaDto = new SalidaDto();
        salidaDto.setComicsSuperanTamanio(
                this.comicRepository.consultarComicTamanioNombreMayor(lengthComic.intValue())
        );
        salidaDto.setComicsNoSuperanTamanio(
                this.comicRepository.consultarComicTamanioNombreMenor(lengthComic.intValue())
        );
        return salidaDto;
    }
}

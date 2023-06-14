package com.heinsohn.tienda.config;

import com.heinsohn.tienda.dto.ComicDto;
import com.heinsohn.tienda.enums.EstadoEnum;
import com.heinsohn.tienda.enums.TematicaEnum;
import com.heinsohn.tienda.exception.TiendaComicException;
import com.heinsohn.tienda.interfaz.IGestionarComic;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;


/**
 * Clase para la creacion de los 20 comics.
 * @author Nelson Cortes
 */
@Component
@RequiredArgsConstructor
public class DefaultAdminRunner implements ApplicationRunner {


    private final IGestionarComic gestionarComic;


    @Override
    public void run(ApplicationArguments args) throws Exception {
//        this.createComics();
    }

    /**
     * <p>
     *     Metodo que permite la creacion de los 20 comics.
     * </p>
     * @throws TiendaComicException
     */
    private void createComics() throws TiendaComicException {
//        for (int i = 0; i < 20; i++) {
//            this.gestionarComic.createComic(
//                    this.generarComic(i % 2 == 0, i + 2)
//            );
//        }
    }

    /**
     * <p>
     *     Metodo que permite crear un comic con unos atributos aleatorios.
     * </p>
     *
     * @param color indica el color del comic.
     * @param numberString indica la longitud de la cadena de sus atributos.
     * @return devuelve un comic, con unos atributos aleatorios.
     */
//    private ComicDto generarComic(Boolean color, int numberString) {
//        return new ComicDto(this.generateString(numberString),
//                this.generateString(numberString),
//                this.selectTematicaEnum(),
//                this.generateString(numberString),
//                numberString,
//                new BigDecimal(numberString),
//                this.generateString(numberString),
//                color,
//                LocalDate.now(),
//                this.selectEstadoEnum(),
//                numberString
//        );
//    }

    /**
     * <p>
     *     Metodo que devuelve una cadena random con un tamanio especifico.
     * </p>
     * @param number indica el el tamanio de la cadena.
     * @return devuelve una cadena aleatoria.
     */
    private String generateString(int number) {
        StringBuilder name = new StringBuilder();
        for (int i = 0; i < number; i++) {
            name.append((char) ((Math.random() * 26) + 97));
        }
        return name.toString();
    }

    /**
     * <p>
     *     Metodo que permite escoger una tematica de manera aleatoria.
     * </p>
     * @return devuelve una tematica.
     */
    private TematicaEnum selectTematicaEnum() {
        int random = (int) (Math.random() * 5);
        switch (random) {
            case 0:
                return TematicaEnum.AVENTURAS;
            case 1:
                return TematicaEnum.BELICO;
            case 2:
                return TematicaEnum.DEPORTIVO;
            case 3:
                return TematicaEnum.FANTASTICO;
            default:
                return TematicaEnum.CIENCIA_FICCION;
        }
    }

    /**
     * <p>
     *     Metodo que permite escoger un estado de manera aleatoria.
     * </p>
     * @return devuelve una estado.
     */
    private EstadoEnum selectEstadoEnum() {
        int random = (int) (Math.random() * 2);
        return random < 1 ? EstadoEnum.ACTIVO : EstadoEnum.INACTIVO;
    }


}

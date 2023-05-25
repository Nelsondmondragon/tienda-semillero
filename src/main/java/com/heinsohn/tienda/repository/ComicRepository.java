package com.heinsohn.tienda.repository;

import com.heinsohn.tienda.enums.EstadoEnum;
import com.heinsohn.tienda.model.Comic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ComicRepository extends JpaRepository<Comic, Long> {

    @Query("SELECT c.nombre FROM Comic c")
    List<Comic> findAllNamesComics();

    @Query("SELECT c FROM Comic c WHERE c.id = :idComic")
    Comic obtenerComicPorId(@Param("idComic") Long id);

    @Query("SELECT c FROM Comic c WHERE c.nombre LIKE (%:character%) " +
            "AND c.estadoEnum = :estado ORDER BY c.nombre DESC")
    List<Comic> obtenerComicCharacterAndEstadoEnum(@Param("character") String character,
                                                   @Param("estado") EstadoEnum estado);

    @Query("SELECT c FROM Comic c WHERE c.nombre = :nombreComic")
    Comic consultarComicPorNombre(@Param("nombreComic") String nombreComic);


    @Query("UPDATE Comic c SET c.estadoEnum = :estado " +
            "WHERE c.id = :idComic")
    Comic actualizarEstadoComicPorId(@Param("estado") EstadoEnum estado,
                                     @Param("idComic") Long idComic);


    @Query("UPDATE Comic c SET c.estadoEnum = :estado " +
            "WHERE c.id IN (:listIdComic)")
    @Modifying
    @Transactional
    Comic actualizarEstadoComicPorIdS(@Param("estado") EstadoEnum estado,
                                      @Param("listIdComic") List<Long> listIdComic);

    @Query("DELETE FROM Comic WHERE estadoEnum = :estado")
    @Modifying
    @Transactional
    int eliminarComicPorEstado(@Param("estado") EstadoEnum estadoEnum);

}

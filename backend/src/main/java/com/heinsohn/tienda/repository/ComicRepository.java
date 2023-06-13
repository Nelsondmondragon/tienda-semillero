package com.heinsohn.tienda.repository;

import com.heinsohn.tienda.dto.ComicDto;
import com.heinsohn.tienda.dto.ComicNombreDto;
import com.heinsohn.tienda.dto.ConsultaNombrePrecioDto;
import com.heinsohn.tienda.enums.EstadoEnum;
import com.heinsohn.tienda.exception.GestionarComicException;
import com.heinsohn.tienda.model.Comic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ComicRepository extends JpaRepository<Comic, Long> {


    List<Comic> findByNombre(String nombre);

    List<Comic> findByNombreIsNot(String nombre);

    List<Comic> findByFechaVentaIsNull();

    List<Comic> findByFechaVentaIsNotNull();

    List<Comic> findByColorTrue();

    List<Comic> findByColorFalse();

    List<Comic> findByNombreContaining(String cadena);

    List<Comic> findByPrecioLessThan(BigDecimal precio);

    List<Comic> findByPrecioLessThanEqual(BigDecimal precio);

    List<Comic> findByPrecioGreaterThan(BigDecimal precio);

    List<Comic> findByPrecioGreaterThanEqual(BigDecimal precio);

    List<Comic> findByPrecioGreaterThanEqualAndEstadoEnumEquals(BigDecimal precio, EstadoEnum estado);


    @Query("SELECT c.nombre FROM Comic c")
    List<String> findAllNamesComics();

    @Query("SELECT c.nombre FROM Comic c")
    Page<String> findAllNamesComics(PageRequest pageRequest);

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


    @Query(value = "SELECT SCNOMBRE,SCPRECIO from comic where  SCID = :idComic", nativeQuery = true)
    Object[][] obtenerQueryNative(@Param("idComic") Long idComic);


    @Query(value = "SELECT new com.heinsohn.tienda.dto.ConsultaNombrePrecioDto(c.nombre,c.precio) FROM Comic c where  c.id= :idComic ")
    ConsultaNombrePrecioDto obtenerNombreYPrecio(@Param("idComic") Long idComic) throws GestionarComicException;

    @Query(value = "SELECT c.nombre FROM Comic c where LENGTH(c.nombre)>= :lengthComic ")
    List<String> consultarComicTamanioNombreMayor(@Param("lengthComic") Integer lengthComic);


    @Query(value = "SELECT c.nombre FROM Comic c where LENGTH(c.nombre)< :lengthComic ")
    List<String> consultarComicTamanioNombreMenor(@Param("lengthComic") Integer lengthComic);


}

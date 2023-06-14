package com.heinsohn.tienda.dto;

import com.heinsohn.tienda.enums.EstadoEnum;
import com.heinsohn.tienda.enums.TematicaEnum;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ComicDto implements Serializable {

    private Long id;
    private String nombre;
    private String editorial;
    @Enumerated(EnumType.STRING)
    private TematicaEnum tematicaEnum;
    private String coleccion;
    private Integer numeroPaginas;
    private BigDecimal precio;
    private String autores;
    private Boolean color;
    private LocalDate fechaVenta;
    @Enumerated(EnumType.STRING)
    private EstadoEnum estadoEnum;
    private Integer cantidad;

}

package com.heinsohn.tienda.dto;

import com.heinsohn.tienda.enums.EstadoEnum;
import com.heinsohn.tienda.enums.TematicaEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ComicDto implements Serializable {

    private Long id;
    private String nombre;
    private String editorial;
    private TematicaEnum tematicaEnum;
    private BigDecimal precio;
    private LocalDate fechaVenta;
    private Boolean color;
    private String coleccion;
    private Integer numeroPaginas;
    private EstadoEnum estadoEnum;
    private Integer cantidad;

}

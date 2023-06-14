package com.heinsohn.tienda.dto;

import com.heinsohn.tienda.enums.EstadoEnum;
import com.heinsohn.tienda.enums.TematicaEnum;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;
import java.time.LocalDate;

public class ComicCompraDto {


    private Long id;

    private String nombre;

    private LocalDate fechaVenta;
    @Enumerated(EnumType.STRING)
    private EstadoEnum estadoEnum;
    private Integer cantidad;
}

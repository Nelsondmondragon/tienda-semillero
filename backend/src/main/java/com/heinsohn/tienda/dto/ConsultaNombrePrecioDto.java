package com.heinsohn.tienda.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConsultaNombrePrecioDto {

    private String nombre;
    private BigDecimal precio;
}

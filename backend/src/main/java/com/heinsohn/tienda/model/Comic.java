package com.heinsohn.tienda.model;

import com.heinsohn.tienda.enums.EstadoEnum;
import com.heinsohn.tienda.enums.TematicaEnum;
import lombok.*;

import javax.persistence.*;
import java.lang.annotation.Native;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "COMIC")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Comic {
    @Id
    @SequenceGenerator(name = "COMIC_SCID_GENERATOR", sequenceName = "SEQ_COMIC", allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE, generator = "COMIC_SCID_GENERATOR"

    )
    @Column(name = "SCID")
    private Long id;
    @Column(name = "SCNOMBRE")
    private String nombre;
    @Column(name = "SCEDITORIAL")
    private String editorial;
    @Column(name = "SCTEMATICA")
    @Enumerated(EnumType.STRING)
    private TematicaEnum tematicaEnum;
    @Column(name = "SCCOLECCION")
    private String coleccion;
    @Column(name = "SCNUMEROPAGINAS")
    private Integer numeroPaginas;
    @Column(name = "SCPRECIO")
    private BigDecimal precio;
    @Column(name = "SCAUTORES")
    private String autores;
    @Column(name = "SCCOLOR")
    private Boolean color;
    @Column(name = "SCFECHA_VENTA")
    private LocalDate fechaVenta;
    @Column(name = "SCESTADO")
    @Enumerated(EnumType.STRING)
    private EstadoEnum estadoEnum;
    @Column(name = "SCCANTIDAD")
    private Integer cantidad;

}

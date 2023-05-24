package com.heinsohn.tienda.model;

import com.heinsohn.tienda.enums.TematicaEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.lang.annotation.Native;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "COMIC")
public class Comic {
    @Id
    @SequenceGenerator(name = "COMIC_SCID_GENERATOR", sequenceName = "SEQ_COMIC")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE, generator = "COMIC_SCID_GENERATOR"

    )
    @Column(name = "SCID")
    private Integer id;
    @Column(name = "SCNOMBRE")
    private String nombre;
    @Column(name = "SCEDITORIAL")
    private String editorial;
    @Column(name = "SCTEMATICA")
    @Enumerated(EnumType.STRING)
    private TematicaEnum tematicaEnum;
    @Column(name = "SCPRECIO")
    private BigDecimal precio;
    @Column(name = "SCFECHA_VENTA")
    private LocalDate fechaVenta;
    @Column(name = "SCCOLOR")
    private Character color;

}

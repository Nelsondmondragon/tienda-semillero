package com.heinsohn.tienda.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SalidaDto {

    private List<String> comicsNoSuperanTamanio;
    private List<String> comicsSuperanTamanio;
}

package com.heinsohn.tienda.enums;

public enum TICOEnum {
    TICO_9999("Se ha presentado un error tecnico", "TICO_9999"),
    TICO_0001("El idComic %s %s %s %s debe ser mayor a 0", "TICO_0001"),
    TICO_0002("La longitud máxima permitida es de 50 caracteres", "TICO_0002"),
    TICO_0005("El nombre del comic no debe ser mayor a 50 caracteres", "TICO_0005"),

    TICO_0006("La longitud máxima permitida es de %s caracteres", "TICO_0006"),

    TICO_0007("El comic seleccionado no cuenta con stock en bodega", "TICO_0007"),
    TICO_0008("La cantidad existente del comic es:  %s, y supera la ingresada", "TICO_0008"),
    TICO_0009("No existe el comic con el id ingresado", "TICO_0009"),

    ;

    private String message;
    private String code;

    TICOEnum(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }
}

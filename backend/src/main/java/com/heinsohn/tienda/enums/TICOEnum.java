package com.heinsohn.tienda.enums;

public enum TICOEnum {
	TICO_9999("Se ha presentado un error tecnico", "TICO_9999"),
	TICO_0001("El idComic %s %s %s %s debe ser mayor a 0", "TICO_0001"),
	TICO_0002("La longitud máxima permitida es de 50 caracteres", "TICO_0002"),
	TICO_0005("El nombre del comic no debe ser mayor a 50 caracteres", "TICO_0005"),
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

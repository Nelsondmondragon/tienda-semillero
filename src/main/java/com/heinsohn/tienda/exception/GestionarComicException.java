package com.heinsohn.tienda.exception;

import com.heinsohn.tienda.enums.TICOEnum;

public class GestionarComicException extends TiendaComicException {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public GestionarComicException(TICOEnum enumErrors) {
        super(enumErrors);
    }

    public GestionarComicException(TICOEnum enumErrors, String... params) {
        super(enumErrors, params);
    }
}

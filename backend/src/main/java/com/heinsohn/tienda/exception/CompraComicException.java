package com.heinsohn.tienda.exception;

import com.heinsohn.tienda.enums.TICOEnum;

public class CompraComicException extends TiendaComicException {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public CompraComicException(TICOEnum enumErrors) {
        super(enumErrors);
    }

    public CompraComicException(TICOEnum enumErrors, String... params) {
        super(enumErrors, params);
    }

}
package com.heinsohn.tienda.exception;

import com.heinsohn.tienda.enums.TICOEnum;

public class TiendaComicException extends Exception {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * code
     */
    private final String code; // code

    /**
     * Error Code
     */
    private final TICOEnum errorCode;

    /**
     * params
     */
    private Object[] params;

    public TiendaComicException(TICOEnum errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.code = errorCode.name();
    }

    public TiendaComicException(TICOEnum errorCode, String... params) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.code = errorCode.name();
        this.params = params;
    }

    /**
     * @return String
     */
    public String getCode() {
        return code;
    }

    public TICOEnum getErrorCode() {
        return errorCode;
    }

    public Object[] getParams() {
        return params;
    }

}

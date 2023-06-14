package com.heinsohn.tienda.exception;


import com.heinsohn.tienda.dto.ErrorResponse;
import com.heinsohn.tienda.dto.JSONResponse;
import com.heinsohn.tienda.enums.JSONResponseStatus;
import com.heinsohn.tienda.enums.TICOEnum;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


/**
 * @author erik.alvarez
 * @version 1.0
 * @see ExceptionResponseHandler
 * @since Java 1.8
 */
@ControllerAdvice
public class ExceptionResponseHandler extends ResponseEntityExceptionHandler {

    private final static Logger LOG = LogManager.getLogger(ExceptionResponseHandler.class);


    /**
     * @param ex
     * @param request
     * @return ApiResponseEntity<String>
     */
    @ExceptionHandler({Exception.class})
    public JSONResponse<Object> handleGeneralException(Exception ex) {
        LOG.error("General Exception: " + ex);
        return new JSONResponse<>(JSONResponseStatus.ERROR.toString(), HttpStatus.INTERNAL_SERVER_ERROR,
                new ErrorResponse(TICOEnum.TICO_9999.getMessage(), TICOEnum.TICO_9999.name()));
    }

    @ExceptionHandler({GestionarComicException.class})
    public JSONResponse<Object> handlerGestionarComicException(GestionarComicException ex) {
        LOG.error("General GestionarComicException: " + ex);

        String message = ex.getMessage();
        String errors = String.format(message, ex.getParams());

        return new JSONResponse<>(JSONResponseStatus.ERROR.toString(), HttpStatus.CONFLICT,
                new ErrorResponse(errors, ex.getCode()));
    }

    @ExceptionHandler({CompraComicException.class})
    public JSONResponse<Object> handlerGestionarComicException(CompraComicException ex) {
        LOG.error("General CompraComicException: " + ex);

        String message = ex.getMessage();
        String errors = String.format(message, ex.getParams());

        return new JSONResponse<>(JSONResponseStatus.ERROR.toString(), HttpStatus.CONFLICT,
                new ErrorResponse(errors, ex.getCode()));
    }

}

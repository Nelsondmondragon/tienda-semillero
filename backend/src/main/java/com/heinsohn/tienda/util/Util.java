package com.heinsohn.tienda.util;


import com.heinsohn.tienda.dto.JSONResponse;
import com.heinsohn.tienda.enums.JSONResponseStatus;
import org.springframework.http.HttpStatus;

public abstract class Util {
    private static final String SUCCESS = "Comics procesados exitosamente";

    /**
     * @param <T>
     * @param data
     * @return <T> ApiResponseEntity<T>
     */
    protected <T> JSONResponse<T> buildResponse(T data) {
        return new JSONResponse<>(JSONResponseStatus.SUCCESS.toString(), HttpStatus.OK, data);
    }

    /**
     * @param <T>
     * @param data
     * @return <T> ApiResponseEntity<T>
     */
    protected <T> JSONResponse<T> buildResponseCustom(T data) {
        return new JSONResponse<>(JSONResponseStatus.SUCCESS.toString(), HttpStatus.OK, data, SUCCESS);
    }

//    protected <T> JSONResponse<T> buildResponseCustom(T data, String message) {
//        return new JSONResponse<>(JSONResponseStatus.SUCCESS.toString(), HttpStatus.OK, data, message);
//    }

    /**
     * @param <T>
     * @param data
     * @return <T> ApiResponseEntity<T>
     */
//    protected <T> JSONResponse<T> buildResponseCustom(T data) {
//        return new JSONResponse<>(JSONResponseStatus.SUCCESS.toString(), HttpStatus.OK, data);
//    }


    /**
     * @param <T>
     * @param data
     * @param message
     * @param httpStatus
     * @return <T> ApiResponseEntity<T>
     */
    protected <T> JSONResponse<T> buildErrorResponse(T error, HttpStatus httpStatus) {
        return new JSONResponse<>(JSONResponseStatus.ERROR.toString(), httpStatus, error);
    }
}

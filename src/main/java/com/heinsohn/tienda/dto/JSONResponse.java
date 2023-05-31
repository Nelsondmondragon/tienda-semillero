package com.heinsohn.tienda.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class JSONResponse<T> extends ResponseEntity<ApiResponse<T>>{
    
	  /**
     * @param status
     * @param httpStatus
     * @param body
     */
    public JSONResponse(String status, HttpStatus httpStatus, T body) {
        this(status, httpStatus, body, null);
    }

    /**
     * @param status
     * @param httpStatus
     * @param body
     * @param message
     */
    public JSONResponse(String status, HttpStatus httpStatus, T body, String message) {
        super(new ApiResponse<>(status, body, message), httpStatus);
    }

    /**
     * @param status
     * @param httpStatus
     * @param body
     * @param message
     */
    public JSONResponse(String status, HttpStatus httpStatus, T body, String message, String errorcode) {
        super(new ApiResponse<>(status, body, message, errorcode), httpStatus);
    }
    
}
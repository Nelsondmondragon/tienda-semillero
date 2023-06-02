package com.heinsohn.tienda.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

/**
 * Wrapper clase for standard response
 *
 * @param <T>
 * @author hector.gorno
 * @version 1.0
 * @see this
 * @since Java 1.8
 */
@Getter
@Setter
public class ApiResponse<T> {


    /**
     * The status
     */
    public String status; // The status

    /**
     * An informative string message
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String message; // An informative string message

    /**
     * An informative string errorcode
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String errorcode;


    /**
     * The mutable data object
     */
    public T data; // The mutable data object


    /**
     * @param status
     * @param data
     * @param message
     * @param errorcode
     */
    public ApiResponse(String status, T data, String message, String errorcode) {
        this.status = status;
        this.data = data;
        this.message = message;
        this.errorcode = errorcode;
    }

    /**
     * @param status
     * @param data
     * @param message
     */
    public ApiResponse(String status, T data, String message) {
        this(status, data, message, null);
    }

    /**
     * @param status
     * @param data
     */
    public ApiResponse(String status, T data) {
        this(status, data, null);
    }

    public ApiResponse() {
    }
}
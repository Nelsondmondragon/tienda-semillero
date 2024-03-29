package com.heinsohn.tienda.dto;

public class ErrorResponse {
    private String errorMessage;
    private String errorCode;
    
    public ErrorResponse() {
        super();
      }

    public ErrorResponse(String errorMessage, String errorCode) {
      super();
      this.errorMessage = errorMessage;
      this.errorCode = errorCode;
    }

    /**
     * @return the errorMessage
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * @param errorMessage the errorMessage to set
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * @return the errorCode
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * @param errorCode the errorCode to set
     */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
    
}

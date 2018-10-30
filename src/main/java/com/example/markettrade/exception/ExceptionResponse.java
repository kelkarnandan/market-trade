package com.example.markettrade.exception;

import java.util.List;

public class ExceptionResponse {

    private String errorCode;
    private String errorMessage;
    private List<String> errors;

    /**
     * @return The errorCode
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * @param errorCode The errorCode to set
     */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * @return The errorMessage
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * @param errorMessage The errorMessage to set
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * @return The errors
     */
    public List<String> getErrors() {
        return errors;
    }

    /**
     * @param errors The errors to set
     */
    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}

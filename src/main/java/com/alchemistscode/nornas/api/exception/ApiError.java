package com.alchemistscode.nornas.api.exception;

/**
 * Clase que representa un error devuelto por un servicio rest
 */
public class ApiError {
    private String errorCode;
    private String errorMessage;
    private String errorOriginMessaage;

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void setErrorOriginMessaage(String errorOriginMessaage) {
        this.errorOriginMessaage = errorOriginMessaage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getErrorOriginMessaage() {
        return errorOriginMessaage;
    }
}
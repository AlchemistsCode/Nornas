package com.alchemistscode.nornas.api.exception;

import com.alchemistscode.nornas.api.properties.ErrorProperties.Error;

/**
 *
 */
public class AlchemyException extends RuntimeException {

    private final Error error;
    private final String mensajeOriginal;


    public AlchemyException(Error error, Throwable cause, String mensajeOriginal) {
        super(error.getErrorMessage(), cause);
        this.error = error;
        this.mensajeOriginal = mensajeOriginal;
    }

    public Error getError() {
        return error;
    }

    public String getMensajeOriginal() {
        return mensajeOriginal;
    }
}
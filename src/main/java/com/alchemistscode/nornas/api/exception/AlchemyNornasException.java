package com.alchemistscode.nornas.api.exception;

import com.alchemistscode.nornas.api.properties.ErrorProperties.Error;

/**
 *
 */
public class AlchemyNornasException extends RuntimeException {

    private final Error error;
    private final String mensajeOriginal;


    public AlchemyNornasException(String mensaje, Error error, Throwable cause,
                                String mensajeOriginal) {
        super(mensaje, cause);
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
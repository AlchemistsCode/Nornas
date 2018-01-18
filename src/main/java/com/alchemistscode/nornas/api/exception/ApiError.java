package com.alchemistscode.nornas.api.exception;

import lombok.Data;

/**
 * Clase que representa un error devuelto por un servicio rest
 */
@Data
public class ApiError {
    private String errorCode;
    private String message;
    private String originalErrorMessage;
}
package com.alchemistscode.nornas.api.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Clase que representa un error devuelto por un servicio rest
 */
@Data
@AllArgsConstructor
public class ApiError {
    private String errorCode;
    private String errorMessage;
    private String errorOriginMessaage;
}
package com.alchemistscode.nornas.api.controller.handler;

import com.alchemistscode.nornas.api.exception.AlchemyNornasException;
import com.alchemistscode.nornas.api.properties.ErrorProperties;
import com.alchemistscode.nornas.api.properties.ErrorProperties.Error;
import com.alchemistscode.nornas.api.exception.ApiError;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @Autowired
    private ErrorProperties errorProperties;

    @ExceptionHandler(AlchemyNornasException.class)
    protected ResponseEntity<ApiError> handleTelcelException(AlchemyNornasException ex) {
        return new ResponseEntity<>(
                generaApiErrorFromAlchemyException(ex),
                HttpStatus.valueOf(ex.getError().getHttpCode())
        );
    }

    private ApiError generaApiErrorFromAlchemyException(AlchemyNornasException ex) {
        ApiError apiError = new ApiError();
        apiError.setErrorCode(ex.getError().getErrorCode());
        apiError.setMessage(ex.getError().getErrorMessage());
        apiError.setOriginalErrorMessage(ex.getMensajeOriginal());
        return apiError;
    }

    @ExceptionHandler(Throwable.class)
    protected ResponseEntity<ApiError> handleException(Throwable ex) {
        ApiError apiError = generaApiErrorFromException(ex);

        return new ResponseEntity<>(
                apiError,
                HttpStatus.valueOf(errorProperties.getGeneral().get("default").getHttpCode())
        );
    }

    private ApiError generaApiErrorFromException(Throwable ex) {
        ApiError apiError = new ApiError();
        Error error = errorProperties.getGeneral().get("default");
        apiError.setMessage(error.getErrorMessage());
        apiError.setErrorCode(error.getErrorCode());
        apiError.setOriginalErrorMessage(ex.getMessage());
        return apiError;
    }
}
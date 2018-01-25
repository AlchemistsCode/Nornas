package com.alchemistscode.nornas.api.controller.handler;

import com.alchemistscode.nornas.api.exception.AlchemyException;
import com.alchemistscode.nornas.api.exception.ApiError;
import com.alchemistscode.nornas.api.properties.ErrorProperties;
import com.alchemistscode.nornas.api.properties.ErrorProperties.Error;
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

    @ExceptionHandler(AlchemyException.class)
    protected ResponseEntity<ApiError> handleAlchemistsException(AlchemyException exception){
        return new ResponseEntity<ApiError>(generedApiErrorFromApiException(exception),
                HttpStatus.valueOf(exception.getError().getHttpCode()));
    }
    @ExceptionHandler(Throwable.class)
    protected ResponseEntity<ApiError> handleException(Throwable ex) {
        ApiError apiError = generaApiErrorFromException(ex);
        return new ResponseEntity<>(
                apiError,
                HttpStatus.valueOf(errorProperties.getGeneral().get("default").getHttpCode())
        );
    }

    private ApiError generedApiErrorFromApiException(AlchemyException exception){
        ApiError apiError = new ApiError();
        apiError.setErrorCode(exception.getError().getErrorCode());
        apiError.setErrorMessage(exception.getError().getErrorMessage());
        apiError.setErrorOriginMessaage(exception.getMensajeOriginal());
        return apiError;
    }
    private ApiError generaApiErrorFromException(Throwable ex) {
        ApiError apiError = new ApiError();
        Error error = errorProperties.getGeneral().get("default");
        apiError.setErrorMessage(error.getErrorMessage());
        apiError.setErrorCode(error.getErrorCode());
        apiError.setErrorOriginMessaage(ex.getMessage());
        return apiError;
    }
}
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
        return new ResponseEntity<ApiError>(generateApiErrorFromAlchemyException(exception),
                HttpStatus.valueOf(exception.getError().getHttpCode()) );
    }
    @ExceptionHandler(Throwable.class)
    protected ResponseEntity<ApiError> handleException(Throwable exception) {
        return new ResponseEntity<>(generateApiErrorFromException(exception),
                HttpStatus.valueOf(errorProperties.getGeneral().get("default").getHttpCode()) );
    }

    private ApiError generateApiErrorFromAlchemyException(AlchemyException exception){
        return new ApiError(exception.getError().getErrorCode(),
                exception.getError().getErrorMessage(),
                exception.getMensajeOriginal() );
    }
    private ApiError generateApiErrorFromException(Throwable ex) {
        Error error = errorProperties.getGeneral().get("default");
        return new ApiError( error.getErrorCode(),
                error.getErrorMessage(),
                ex.getMessage() );
    }
}
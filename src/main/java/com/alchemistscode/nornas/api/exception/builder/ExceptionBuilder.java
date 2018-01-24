package com.alchemistscode.nornas.api.exception.builder;

import com.alchemistscode.nornas.api.exception.AlchemyNornasException;
import com.alchemistscode.nornas.api.properties.ErrorProperties;
import com.alchemistscode.nornas.api.properties.ErrorProperties.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 *
 */
@Component
public class ExceptionBuilder {
    @Autowired
    private ErrorProperties errorProperties;

    public Builder getBuilder(String servicio) {
        return new Builder(errorProperties, servicio);
    }

    public Builder getBuilder() {
        return new Builder(errorProperties, null);
    }

    public static class Builder {
        private final ErrorProperties errorProperties;
        private Exception e;
        private String originalErrorMessage;
        private String codigoError;
        private String mensaje;
        private String servicio;

        private Builder(ErrorProperties errorProperties, String servicio) {
            this.errorProperties = errorProperties;
            this.servicio = servicio;
        }

        public AlchemyNornasException build() {
            Error error;
            if (servicio != null) {
                error = errorProperties.getErrorConfig(servicio, codigoError);
            } else {
                error = new Error();
                error.setErrorMessage(mensaje);
                error.setErrorCode(codigoError);
                error.setHttpCode(200);
            }

            return new AlchemyNornasException(mensaje, error, e, getMensageErrorOrginal());
        }

        private String getMensageErrorOrginal() {
            if (originalErrorMessage != null) {
                if (codigoError != null) {
                    return codigoError + ":" + originalErrorMessage;
                } else {
                    return originalErrorMessage;
                }
            } else if (codigoError != null) {
                return codigoError;
            } else {
                return null;
            }
        }

        public Builder mensaje(String mensaje) {
            this.originalErrorMessage = mensaje;
            return this;
        }

        public Builder codidgoError(String codigoError) {
            this.codigoError = codigoError;
            return this;
        }

        public Builder exception(Exception e) {
            this.originalErrorMessage = e.getMessage()!=null?e.getMessage():e.toString();
            this.e = e;
            return this;
        }

    }
}
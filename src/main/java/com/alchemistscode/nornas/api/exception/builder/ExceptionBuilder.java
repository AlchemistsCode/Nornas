package com.alchemistscode.nornas.api.exception.builder;

import com.alchemistscode.nornas.api.exception.AlchemyException;
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

    private static final String GENERAL = "general";
    private static final String CODE_DEFAULT = "default";

    public Builder getBuilder(){
        return new Builder(errorProperties,GENERAL);
    }

    public static class Builder{
        private final ErrorProperties errorProperties;
        private Exception exception;
        private String messageOrigin;
        private String errorCode;
        private String service;

        public Builder(ErrorProperties errorProperties, String service){
            this.errorProperties = errorProperties;
            this.service = service;
        }

        public AlchemyException build(){
            Error error = (service != null)
                    ? errorProperties.getErrorConfig(service, errorCode)
                    : errorProperties.getErrorConfig(service, CODE_DEFAULT);

            return new AlchemyException(error, exception, getMessageOrigin());
        }

        private String getMessageOrigin(){
            if (messageOrigin != null && !messageOrigin.isEmpty()){
                return errorCode != null && !errorCode.isEmpty()
                        ? errorCode + ":" + messageOrigin
                        : messageOrigin;
            }
            return (errorCode!= null && !errorCode.isEmpty()) ? errorCode : null ;
        }

        public Builder message(String errorMessage){
            this.messageOrigin = errorMessage;
            return this;
        }

        public Builder errorCode(String errorCode){
            this.errorCode = errorCode;
            return this;
        }

        public Builder exception(Exception exception){
            this.messageOrigin = !exception.getMessage().isEmpty()
                    ? exception.getMessage()
                    : exception.toString() ;
            this.exception = exception;
            return this;
        }
    }
}
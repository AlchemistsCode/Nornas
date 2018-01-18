package com.alchemistscode.nornas.api.properties;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "errors.config")
public class ErrorProperties{
    private Map<String, Map<String, Error>> config = new HashMap<>();

    private static final String GENERAL = "general";
    private static final String DEFAULT = "default";

    public Map<String, Error> getGeneral() {
        return config.computeIfAbsent(GENERAL, k -> new HashMap<>());
    }

    public Error getErrorConfig(String servicio, String errorCode) {
        if (config.containsKey(servicio) && config.get(servicio).containsKey(errorCode)) {
            return config.get(servicio).get(errorCode);
        } else {
            return config.get(GENERAL).get(DEFAULT);
        }
    }

    public static class Error implements Serializable{
        private String errorCode;
        private String errorMessage;
        private Integer httpCode = 500;

        public String getErrorCode() {
            return errorCode;
        }

        public void setErrorCode(String errorCode) {
            this.errorCode = errorCode;
        }

        public String getErrorMessage() {
            return errorMessage;
        }

        public void setErrorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
        }

        public Integer getHttpCode() {
            return httpCode;
        }

        public void setHttpCode(Integer httpCode) {
            this.httpCode = httpCode;
        }
    }
}
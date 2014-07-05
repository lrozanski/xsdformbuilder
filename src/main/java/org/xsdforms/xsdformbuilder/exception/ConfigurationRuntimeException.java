package org.xsdforms.xsdformbuilder.exception;

import java.util.Map;

public class ConfigurationRuntimeException extends RuntimeException {

    private Map<String, String> propertyErrors;

    public ConfigurationRuntimeException(Map<String, String> propertyErrors) {
        super(constructMessage(propertyErrors));
        this.propertyErrors = propertyErrors;
    }

    private static String constructMessage(Map<String, String> propertyErrors) {
        StringBuilder stringBuilder = new StringBuilder();
        if (propertyErrors.size() == 0) {
            return null;
        }
        for (Map.Entry<String, String> entry : propertyErrors.entrySet()) {
            stringBuilder.append(String.format("Error in property '%s': %s\n", entry.getKey(), entry.getValue()));
        }

        return stringBuilder.toString();
    }

    public Map<String, String> getPropertyErrors() {
        return propertyErrors;
    }
}

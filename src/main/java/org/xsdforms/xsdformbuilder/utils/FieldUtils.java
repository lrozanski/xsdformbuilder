package org.xsdforms.xsdformbuilder.utils;

import org.xsdforms.xsdformbuilder.configuration.impl.FieldConfiguration;
import org.xsdforms.xsdformbuilder.exception.FormBuilderRuntimeException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class FieldUtils {

    private FieldUtils() {
    }

    public static FieldConfiguration getDefaultFieldConfiguration() {
        Properties properties = new Properties();
        InputStream inputStream = FormUtils.class.getClassLoader().getResourceAsStream("fieldConfiguration.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new FormBuilderRuntimeException(e);
        }

        return new FieldConfiguration(properties);
    }
}

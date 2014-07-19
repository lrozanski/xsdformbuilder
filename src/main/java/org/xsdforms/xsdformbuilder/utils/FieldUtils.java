package org.xsdforms.xsdformbuilder.utils;

import org.xsdforms.xsdformbuilder.configuration.impl.FieldConfiguration;

public final class FieldUtils {

    private FieldUtils() {
    }

    public static FieldConfiguration getDefaultFieldConfiguration() {
        return new FieldConfiguration();
    }
}

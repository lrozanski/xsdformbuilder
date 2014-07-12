package org.xsdforms.xsdformbuilder.configuration.impl;

import org.xsdforms.xsdformbuilder.configuration.AbstractConfiguration;

import java.util.Locale;
import java.util.Properties;

public class FieldConfiguration extends AbstractConfiguration {

    private static final Long serialVersionUID = -1L;

    public FieldConfiguration(Properties properties) {
        super(properties, Locale.getDefault());
    }

    public FieldConfiguration(Properties properties, Locale locale) {
        super(properties, locale);
    }
}

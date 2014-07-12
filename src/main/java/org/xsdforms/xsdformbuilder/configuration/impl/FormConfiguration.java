package org.xsdforms.xsdformbuilder.configuration.impl;

import org.xsdforms.xsdformbuilder.configuration.AbstractConfiguration;

import java.util.Locale;
import java.util.Properties;

public class FormConfiguration extends AbstractConfiguration {

    private static final Long serialVersionUID = -1L;

    public FormConfiguration(Properties properties) {
        super(properties, Locale.getDefault());
    }

    public FormConfiguration(Properties properties, Locale locale) {
        super(properties, locale);
    }
}

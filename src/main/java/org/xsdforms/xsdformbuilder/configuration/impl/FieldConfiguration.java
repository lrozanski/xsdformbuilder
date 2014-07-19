package org.xsdforms.xsdformbuilder.configuration.impl;

import org.xsdforms.xsdformbuilder.configuration.AbstractConfiguration;

import java.util.Locale;

public class FieldConfiguration extends AbstractConfiguration {

    private static final Long serialVersionUID = -1L;

    public FieldConfiguration() {
        super(Locale.getDefault());
    }

    public FieldConfiguration(Locale locale) {
        super(locale);
    }
}

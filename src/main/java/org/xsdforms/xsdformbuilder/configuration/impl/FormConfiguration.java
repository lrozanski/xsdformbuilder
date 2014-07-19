package org.xsdforms.xsdformbuilder.configuration.impl;

import org.xsdforms.xsdformbuilder.configuration.AbstractConfiguration;

import java.util.Locale;

public class FormConfiguration extends AbstractConfiguration {

    private static final Long serialVersionUID = -1L;

    public FormConfiguration() {
        super(Locale.getDefault());
    }

    public FormConfiguration(Locale locale) {
        super(locale);
    }
}

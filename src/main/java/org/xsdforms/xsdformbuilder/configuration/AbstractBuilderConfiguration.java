package org.xsdforms.xsdformbuilder.configuration;

import java.util.Locale;
import java.util.Properties;

public abstract class AbstractBuilderConfiguration extends AbstractConfiguration {

    private static final Long serialVersionUID = -1L;

    public AbstractBuilderConfiguration(Properties properties) {
        super(properties, Locale.getDefault());
    }

    public AbstractBuilderConfiguration(Properties properties, Locale locale) {
        super(properties, locale);
    }
}

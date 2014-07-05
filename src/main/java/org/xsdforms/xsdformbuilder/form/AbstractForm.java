package org.xsdforms.xsdformbuilder.form;

import org.xsdforms.xsdformbuilder.configuration.impl.FormConfiguration;
import org.xsdforms.xsdformbuilder.configuration.impl.FormPropertyNames;

import java.util.Properties;

public abstract class AbstractForm extends AbstractElement {

    private static final Long serialVersionUID = -1L;

    private String action;
    private String method;

    protected AbstractForm(FormConfiguration formConfiguration) {
        super(formConfiguration);
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * Parses properties and updates current configuration.
     */
    @Override
    protected void parseProperties() {
        super.parseProperties();
        Properties properties = getConfiguration().getProperties();

        String actionProperty = properties.getProperty(FormPropertyNames.ACTION.getValue(), null);
        String methodProperty = properties.getProperty(FormPropertyNames.METHOD.getValue(), null);

        this.action = actionProperty;
        this.method = methodProperty;
    }
}

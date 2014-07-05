package org.xsdforms.xsdformbuilder.form;

import org.xsdforms.xsdformbuilder.configuration.impl.FormConfiguration;

public class Form extends AbstractForm {

    private static final Long serialVersionUID = -1L;

    public Form(FormConfiguration formConfiguration) {
        super(formConfiguration);
        parseProperties();
        validateProperties();
    }
}

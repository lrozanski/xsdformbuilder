package org.xsdforms.xsdformbuilder.form;

import org.xsdforms.xsdformbuilder.configuration.impl.FormConfiguration;

public class Form extends AbstractForm {

    private static final Long serialVersionUID = -1L;

    private static int formCount;

    public Form(FormConfiguration formConfiguration) {
        super(formConfiguration);
        parseProperties();
        validateProperties();

        String id = String.format("form_%s", formCount++);
        this.setId(id);
        this.setName(id);
    }
}

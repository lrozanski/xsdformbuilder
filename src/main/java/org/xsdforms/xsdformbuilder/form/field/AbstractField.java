package org.xsdforms.xsdformbuilder.form.field;

import org.xsdforms.xsdformbuilder.configuration.impl.FieldConfiguration;
import org.xsdforms.xsdformbuilder.form.AbstractElement;
import org.xsdforms.xsdformbuilder.form.AbstractForm;

import java.io.Serializable;

public abstract class AbstractField extends AbstractElement {

    private static final Long serialVersionUID = -1L;

    private AbstractForm parentForm;

    protected AbstractField(FieldConfiguration configuration, AbstractForm parentForm) {
        super(configuration);
        this.parentForm = parentForm;
        validateProperties();
        parseProperties();
    }

    public AbstractForm getParentForm() {
        return parentForm;
    }

    public void setParentForm(AbstractForm parentForm) {
        this.parentForm = parentForm;
    }
}

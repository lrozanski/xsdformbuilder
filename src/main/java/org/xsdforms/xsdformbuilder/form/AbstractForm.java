package org.xsdforms.xsdformbuilder.form;

import org.xsdforms.xsdformbuilder.configuration.impl.FormConfiguration;
import org.xsdforms.xsdformbuilder.form.field.AbstractField;

import java.util.List;

public abstract class AbstractForm extends AbstractElement {

    private static final Long serialVersionUID = -1L;

    private String action;
    private String method;
    private List<AbstractField> fields;

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

    public List<AbstractField> getFields() {
        return fields;
    }

    public void setFields(List<AbstractField> fields) {
        this.fields = fields;
    }
}

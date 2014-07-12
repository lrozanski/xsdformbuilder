package org.xsdforms.xsdformbuilder.form.field;

import org.xsdforms.xsdformbuilder.configuration.impl.FieldConfiguration;
import org.xsdforms.xsdformbuilder.form.AbstractElement;
import org.xsdforms.xsdformbuilder.form.AbstractForm;

public abstract class AbstractField extends AbstractElement {

    private static final Long serialVersionUID = -1L;

    private AbstractForm parentForm;
    private String name;
    private String label;
    private Boolean required;

    protected AbstractField(FieldConfiguration configuration, AbstractForm parentForm, String name, String label) {
        super(configuration);
        validateProperties();
        parseProperties();
        this.name = name;
        this.label = label;
        this.parentForm = parentForm;
    }

    protected AbstractField(FieldConfiguration configuration, AbstractForm parentForm, String name, String label,
                            Boolean required) {
        super(configuration);
        validateProperties();
        parseProperties();
        this.name = name;
        this.label = label;
        this.parentForm = parentForm;
        this.required = required;
    }

    public AbstractForm getParentForm() {
        return parentForm;
    }

    public void setParentForm(AbstractForm parentForm) {
        this.parentForm = parentForm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }
}

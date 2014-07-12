package org.xsdforms.xsdformbuilder.builder.field;

import org.xsdforms.xsdformbuilder.builder.AbstractBuilder;
import org.xsdforms.xsdformbuilder.form.Form;
import org.xsdforms.xsdformbuilder.form.field.AbstractField;

public abstract class AbstractFieldBuilder extends AbstractBuilder<AbstractField> {

    private Form parentForm;
    private String id;
    private String name;
    private String label;

    protected AbstractFieldBuilder(Form parentForm) {
        this.parentForm = parentForm;
    }

    protected AbstractFieldBuilder(Form parentForm, String id) {
        this.parentForm = parentForm;
        this.id = id;
    }

    public AbstractFieldBuilder(Form parentForm, String id, String name) {
        this.parentForm = parentForm;
        this.id = id;
        this.name = name;
    }

    public AbstractFieldBuilder(Form parentForm, String id, String name, String label) {
        this.parentForm = parentForm;
        this.id = id;
        this.name = name;
        this.label = label;
    }

    public Form getParentForm() {
        return parentForm;
    }

    public void setParentForm(Form parentForm) {
        this.parentForm = parentForm;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLabel() {
        return label;
    }

    public AbstractFieldBuilder withId(String id) {
        this.id = id;
        return this;
    }

    public AbstractFieldBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public AbstractFieldBuilder withLabel(String label) {
        this.label = label;
        return this;
    }
}

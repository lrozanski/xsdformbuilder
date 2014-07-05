package org.xsdforms.xsdformbuilder.form.field;

import org.xsdforms.xsdformbuilder.configuration.impl.FieldConfiguration;
import org.xsdforms.xsdformbuilder.form.AbstractForm;

public class TextField extends AbstractField {

    private static final Long serialVersionUID = -1L;

    private String label;
    private String value;
    private Integer minLength;
    private Integer maxLength;
    private Boolean multiLine;

    public TextField(FieldConfiguration configuration, AbstractForm parentForm,
                     String label, String value, Boolean multiLine) {
        super(configuration, parentForm);
        this.label = label;
        this.value = value;
        this.multiLine = multiLine;
    }

    public TextField(FieldConfiguration configuration, AbstractForm parentForm,
                     String label, String value, Boolean multiLine, Integer maxLength) {
        super(configuration, parentForm);
        this.label = label;
        this.value = value;
        this.multiLine = multiLine;
        this.maxLength = maxLength;
    }

    public TextField(FieldConfiguration configuration, AbstractForm parentForm,
                     String label, String value, Boolean multiLine, Integer minLength, Integer maxLength) {
        super(configuration, parentForm);
        this.label = label;
        this.value = value;
        this.multiLine = multiLine;
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getMinLength() {
        return minLength;
    }

    public void setMinLength(Integer minLength) {
        this.minLength = minLength;
    }

    public Integer getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(Integer maxLength) {
        this.maxLength = maxLength;
    }

    public Boolean isMultiLine() {
        return multiLine;
    }

    public void setMultiLine(Boolean multiLine) {
        this.multiLine = multiLine;
    }
}

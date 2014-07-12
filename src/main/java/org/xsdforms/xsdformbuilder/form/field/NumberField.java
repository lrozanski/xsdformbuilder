package org.xsdforms.xsdformbuilder.form.field;

import org.xsdforms.xsdformbuilder.configuration.impl.FieldConfiguration;
import org.xsdforms.xsdformbuilder.form.AbstractForm;

public class NumberField extends AbstractField {

    private static final Long serialVersionUID = -1L;

    private static int fieldCount;

    private Double value;
    private Integer minValue;
    private Integer maxValue;
    private Integer decimalPlaces;

    public NumberField(FieldConfiguration configuration, AbstractForm parentForm, String name,
                       String label, Double value, Integer decimalPlaces) {
        super(configuration, parentForm, name, label);
        this.value = value;
        this.decimalPlaces = decimalPlaces;
        String id = String.format("%s_field_%s_%s", parentForm.getId(), fieldCount++, label);
        this.setId(id);
        this.getCssClasses().add("xsd-field-number");
    }

    public NumberField(FieldConfiguration configuration, AbstractForm parentForm, String name,
                       String label, Double value, Integer minValue, Integer maxValue, Integer decimalPlaces) {
        super(configuration, parentForm, name, label);
        this.value = value;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.decimalPlaces = decimalPlaces;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Integer getMinValue() {
        return minValue;
    }

    public void setMinValue(Integer minValue) {
        this.minValue = minValue;
    }

    public Integer getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Integer maxValue) {
        this.maxValue = maxValue;
    }

    public Integer getDecimalPlaces() {
        return decimalPlaces;
    }

    public void setDecimalPlaces(Integer decimalPlaces) {
        this.decimalPlaces = decimalPlaces;
    }
}

package org.xsdforms.xsdformbuilder.configuration.impl;

public enum FormPropertyNames {
    ID("id"),
    NAME("name"),
    ACTION("action"),
    CSS_CLASSES("cssClasses"),
    DATA_ATTRIBUTES("dataAttributes"),
    METHOD("method");

    private String value;

    FormPropertyNames(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

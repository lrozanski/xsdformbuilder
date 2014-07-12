package org.xsdforms.xsdformbuilder.builder;

public abstract class AbstractBuilder<T> {

    protected AbstractBuilder() {
    }

    public abstract T build();
}

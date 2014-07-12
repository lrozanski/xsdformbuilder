package org.xsdforms.xsdformbuilder.writer.field;

import org.xsdforms.xsdformbuilder.writer.form.AbstractFormWriterStep;

public class FieldWriterAttributeStep extends AbstractFormWriterStep {

    public FieldWriterAttributeStep(StringBuilder output) {
        super(output);
    }

    public FieldWriterAttributeStep writeAttribute(String name, String value) {
        getOutput().append(String.format(" %s=\"%s\"", name, value));
        return this;
    }

    public StringBuilder writeCloseElement() {
        getOutput().append(" />");
        return getOutput();
    }
}

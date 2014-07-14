package org.xsdforms.xsdformbuilder.writer.bootstrap3.field;

import org.xsdforms.xsdformbuilder.writer.field.AbstractFieldWriterStep;

public class FieldWriterAttributeStep extends AbstractFieldWriterStep {

    public FieldWriterAttributeStep(StringBuilder output) {
        super(output);
    }

    public FieldWriterAttributeStep writeAttribute(String name, String value) {
        getOutput().append(String.format(" %s=\"%s\"", name, value));
        return this;
    }

    public FieldWriterFormGroupEndStep writeCloseElement() {
        getOutput().append(" />");
        return new FieldWriterFormGroupEndStep(getOutput());
    }
}

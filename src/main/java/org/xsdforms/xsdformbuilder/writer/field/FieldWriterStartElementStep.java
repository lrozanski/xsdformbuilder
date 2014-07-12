package org.xsdforms.xsdformbuilder.writer.field;

import org.xsdforms.xsdformbuilder.writer.form.AbstractFormWriterStep;

public class FieldWriterStartElementStep extends AbstractFormWriterStep {

    public FieldWriterStartElementStep(StringBuilder output) {
        super(output);
    }

    public FieldWriterAttributeStep writeStartElement() {
        getOutput().append("<input");
        return new FieldWriterAttributeStep(getOutput());
    }
}

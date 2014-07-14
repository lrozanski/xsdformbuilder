package org.xsdforms.xsdformbuilder.writer.bootstrap3.field;

import org.xsdforms.xsdformbuilder.writer.field.AbstractFieldWriterStep;

public class FieldWriterStartElementStep extends AbstractFieldWriterStep {

    public FieldWriterStartElementStep(StringBuilder output) {
        super(output);
    }

    public FieldWriterAttributeStep writeStartElement() {
        getOutput().append("<input");
        return new FieldWriterAttributeStep(getOutput());
    }
}

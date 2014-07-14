package org.xsdforms.xsdformbuilder.writer.field;

public class FieldWriterStartElementStep extends AbstractFieldWriterStep {

    public FieldWriterStartElementStep(StringBuilder output) {
        super(output);
    }

    public FieldWriterAttributeStep writeStartElement() {
        getOutput().append("<input");
        return new FieldWriterAttributeStep(getOutput());
    }
}

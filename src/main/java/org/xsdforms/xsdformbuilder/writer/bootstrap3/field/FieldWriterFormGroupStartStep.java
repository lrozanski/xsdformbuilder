package org.xsdforms.xsdformbuilder.writer.bootstrap3.field;

import org.xsdforms.xsdformbuilder.writer.field.AbstractFieldWriterStep;

public class FieldWriterFormGroupStartStep extends AbstractFieldWriterStep {

    public FieldWriterFormGroupStartStep(StringBuilder output) {
        super(output);
    }

    public FieldWriterLabelStep writeFormGroupStartElement() {
        getOutput().append("<div class=\"form-group\">");
        return new FieldWriterLabelStep(getOutput());
    }
}

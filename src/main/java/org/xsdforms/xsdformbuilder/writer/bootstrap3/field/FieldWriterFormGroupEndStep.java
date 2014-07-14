package org.xsdforms.xsdformbuilder.writer.bootstrap3.field;

import org.xsdforms.xsdformbuilder.writer.field.AbstractFieldWriterStep;

public class FieldWriterFormGroupEndStep extends AbstractFieldWriterStep {

    public FieldWriterFormGroupEndStep(StringBuilder output) {
        super(output);
    }

    public StringBuilder writeFormGroupEndElement() {
        getOutput().append("</div>");
        return getOutput();
    }
}

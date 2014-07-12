package org.xsdforms.xsdformbuilder.writer.field;

public class AbstractFieldWriterStep {

    private StringBuilder output;

    public AbstractFieldWriterStep(StringBuilder output) {
        this.output = output;
    }

    protected StringBuilder getOutput() {
        return output;
    }
}

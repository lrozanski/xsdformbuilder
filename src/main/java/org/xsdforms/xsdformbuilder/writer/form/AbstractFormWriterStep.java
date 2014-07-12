package org.xsdforms.xsdformbuilder.writer.form;

public abstract class AbstractFormWriterStep {

    private StringBuilder output;

    public AbstractFormWriterStep(StringBuilder output) {
        this.output = output;
    }

    protected StringBuilder getOutput() {
        return output;
    }
}

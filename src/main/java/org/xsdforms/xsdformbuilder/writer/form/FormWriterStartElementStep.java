package org.xsdforms.xsdformbuilder.writer.form;

public class FormWriterStartElementStep extends AbstractFormWriterStep {

    public FormWriterStartElementStep(StringBuilder output) {
        super(output);
    }

    public FormWriterAttributeStep writeStartElement() {
        getOutput().append("<form");
        return new FormWriterAttributeStep(getOutput());
    }
}

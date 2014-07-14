package org.xsdforms.xsdformbuilder.writer.bootstrap3.form;

import org.xsdforms.xsdformbuilder.writer.form.AbstractFormWriterStep;

public class FormWriterStartElementStep extends AbstractFormWriterStep {

    public FormWriterStartElementStep(StringBuilder output) {
        super(output);
    }

    public FormWriterAttributeStep writeStartElement() {
        getOutput().append("<form");
        return new FormWriterAttributeStep(getOutput());
    }
}

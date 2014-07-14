package org.xsdforms.xsdformbuilder.writer.bootstrap3.form;

import org.xsdforms.xsdformbuilder.writer.form.AbstractFormWriterStep;

public class FormWriterAttributeStep extends AbstractFormWriterStep {

    public FormWriterAttributeStep(StringBuilder output) {
        super(output);
    }

    public FormWriterAttributeStep writeAttribute(String name, String value) {
        getOutput().append(String.format(" %s=\"%s\"", name, value));
        return this;
    }

    public FormWriterValueStep closeStartingTag() {
        getOutput().append(">");
        return new FormWriterValueStep(getOutput());
    }
}

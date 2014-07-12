package org.xsdforms.xsdformbuilder.writer.form;

import org.xsdforms.xsdformbuilder.form.field.AbstractField;
import org.xsdforms.xsdformbuilder.writer.FieldHtmlWriter;

public class FormWriterValueStep extends AbstractFormWriterStep {

    public FormWriterValueStep(StringBuilder output) {
        super(output);
    }

    public FormWriterValueStep writeField(AbstractField field) {
        FieldHtmlWriter fieldHtmlWriter = new FieldHtmlWriter();
        fieldHtmlWriter.write(field);
        getOutput().append(fieldHtmlWriter.flush());
        return this;
    }

    public StringBuilder writeCloseElement() {
        getOutput().append("</form>");
        return getOutput();
    }
}

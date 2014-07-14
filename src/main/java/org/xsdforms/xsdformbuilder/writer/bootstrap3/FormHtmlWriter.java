package org.xsdforms.xsdformbuilder.writer.bootstrap3;

import org.apache.commons.lang.StringUtils;
import org.xsdforms.xsdformbuilder.form.AbstractForm;
import org.xsdforms.xsdformbuilder.form.field.AbstractField;
import org.xsdforms.xsdformbuilder.writer.AbstractFormHtmlWriter;
import org.xsdforms.xsdformbuilder.writer.bootstrap3.form.FormWriterAttributeStep;
import org.xsdforms.xsdformbuilder.writer.bootstrap3.form.FormWriterStartElementStep;
import org.xsdforms.xsdformbuilder.writer.bootstrap3.form.FormWriterValueStep;

import java.util.Collection;
import java.util.Map;

public class FormHtmlWriter extends AbstractFormHtmlWriter {

    @Override
    public void write(AbstractForm... values) {
        for (AbstractForm form : values) {
            FormWriterStartElementStep formWriterStartElementStep = new FormWriterStartElementStep(getOutput());
            FormWriterAttributeStep formWriterAttributeStep = formWriterStartElementStep.writeStartElement();
            formWriterAttributeStep.writeAttribute("role", "form");
            formWriterAttributeStep.writeAttribute("id", form.getId());
            formWriterAttributeStep.writeAttribute("name", form.getName());
            formWriterAttributeStep.writeAttribute("class", cssClassesToString(form.getCssClasses()));
            formWriterAttributeStep.writeAttribute("action", form.getAction());
            formWriterAttributeStep.writeAttribute("method", form.getMethod());
            if (form.getDataAttributes() != null) {
                for (Map.Entry<String, String> dataAttribute : form.getDataAttributes().entrySet()) {
                    String key = String.format("data-%s", dataAttribute.getKey());
                    formWriterAttributeStep.writeAttribute(key, dataAttribute.getValue());
                }
            }
            FormWriterValueStep formWriterValueStep = formWriterAttributeStep.closeStartingTag();
            if (form.getFields() != null) {
                for (AbstractField field : form.getFields()) {
                    formWriterValueStep.writeField(field);
                }
            }
            formWriterValueStep.writeCloseElement();
        }
    }

    private String cssClassesToString(Collection<String> cssClasses) {
        return StringUtils.join(cssClasses.toArray(), " ");
    }
}

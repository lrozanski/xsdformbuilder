package org.xsdforms.xsdformbuilder.writer;

import org.apache.commons.lang.StringUtils;
import org.xsdforms.xsdformbuilder.form.field.AbstractField;
import org.xsdforms.xsdformbuilder.form.field.NumberField;
import org.xsdforms.xsdformbuilder.form.field.TextField;
import org.xsdforms.xsdformbuilder.writer.field.FieldWriterAttributeStep;
import org.xsdforms.xsdformbuilder.writer.field.FieldWriterStartElementStep;

import java.util.Collection;
import java.util.Map;

public class FieldHtmlWriter extends AbstractHtmlFieldWriter {

    @Override
    public void write(AbstractField... values) {
        for (AbstractField field : values) {
            FieldWriterStartElementStep fieldWriterStartElementStep = new FieldWriterStartElementStep(getOutput());
            FieldWriterAttributeStep fieldWriterAttributeStep = fieldWriterStartElementStep.writeStartElement();
            fieldWriterAttributeStep.writeAttribute("id", field.getId());
            fieldWriterAttributeStep.writeAttribute("name", field.getName());
            fieldWriterAttributeStep.writeAttribute("class", cssClassesToString(field.getCssClasses()));
            if (field.getDataAttributes() != null) {
                for (Map.Entry<String, String> dataAttribute : field.getDataAttributes().entrySet()) {
                    String key = String.format("data-%s", dataAttribute.getKey());
                    fieldWriterAttributeStep.writeAttribute(key, dataAttribute.getValue());
                }
            }

            if (field.getRequired() != null && field.getRequired()) {
                fieldWriterAttributeStep.writeAttribute("required", "required");
            }

            if (field instanceof TextField) {
                TextField textField = (TextField) field;
                fieldWriterAttributeStep.writeAttribute("type", "text");
                fieldWriterAttributeStep.writeAttribute("value", textField.getValue());
                if (textField.getMinLength() != null || textField.getMaxLength() != null) {
                    fieldWriterAttributeStep.writeAttribute("pattern", lengthConstraintsToString(
                            textField.getMinLength(), textField.getMaxLength()));
                }
            } else if (field instanceof NumberField) {
                NumberField numberField = (NumberField) field;
                fieldWriterAttributeStep.writeAttribute("type", "number");
                fieldWriterAttributeStep.writeAttribute("value", numberField.getValue().toString());
                if (numberField.getMinValue() != null) {
                    fieldWriterAttributeStep.writeAttribute("min", numberField.getMinValue().toString());
                }
                if (numberField.getMaxValue() != null) {
                    fieldWriterAttributeStep.writeAttribute("min", numberField.getMaxValue().toString());
                }
            }
            fieldWriterAttributeStep.writeCloseElement();
        }
    }

    private String cssClassesToString(Collection<String> cssClasses) {
        return StringUtils.join(cssClasses.toArray(), " ");
    }

    private String lengthConstraintsToString(Integer min, Integer max) {
        return String.format(
                ".{%s,%s}",
                (min == null) ? "" : min,
                (max == null) ? "" : max
        );
    }
}

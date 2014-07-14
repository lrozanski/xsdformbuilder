package org.xsdforms.xsdformbuilder.writer.bootstrap3;

import org.apache.commons.lang.StringUtils;
import org.xsdforms.xsdformbuilder.form.field.AbstractField;
import org.xsdforms.xsdformbuilder.form.field.NumberField;
import org.xsdforms.xsdformbuilder.form.field.TextField;
import org.xsdforms.xsdformbuilder.writer.AbstractHtmlFieldWriter;
import org.xsdforms.xsdformbuilder.writer.bootstrap3.field.FieldWriterFormGroupEndStep;
import org.xsdforms.xsdformbuilder.writer.bootstrap3.field.FieldWriterFormGroupStartStep;
import org.xsdforms.xsdformbuilder.writer.bootstrap3.field.FieldWriterLabelStep;
import org.xsdforms.xsdformbuilder.writer.bootstrap3.field.FieldWriterStartElementStep;
import org.xsdforms.xsdformbuilder.writer.bootstrap3.field.FieldWriterAttributeStep;

import java.util.Collection;
import java.util.Map;

public class FieldHtmlWriter extends AbstractHtmlFieldWriter {

    @Override
    public void write(AbstractField... values) {
        for (AbstractField field : values) {
            FieldWriterFormGroupStartStep fieldWriterFormGroupStartStep = new FieldWriterFormGroupStartStep(getOutput());
            FieldWriterLabelStep fieldWriterLabelStep = fieldWriterFormGroupStartStep.writeFormGroupStartElement();
            FieldWriterStartElementStep fieldWriterStartElementStep = fieldWriterLabelStep.writeLabel(
                    field.getId(), field.getLabel());
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
            FieldWriterFormGroupEndStep fieldWriterFormGroupEndStep = fieldWriterAttributeStep.writeCloseElement();
            fieldWriterFormGroupEndStep.writeFormGroupEndElement();
        }
    }

    private String cssClassesToString(Collection<String> cssClasses) {
        return String.format("form-control %s", StringUtils.join(cssClasses.toArray(), " "));
    }

    private String lengthConstraintsToString(Integer min, Integer max) {
        return String.format(
                ".{%s,%s}",
                (min == null) ? "" : min,
                (max == null) ? "" : max
        );
    }
}

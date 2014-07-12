package org.xsdforms.xsdformbuilder.builder.field;

import org.xsdforms.xsdformbuilder.form.Form;
import org.xsdforms.xsdformbuilder.form.field.AbstractField;
import org.xsdforms.xsdformbuilder.form.field.TextField;
import org.xsdforms.xsdformbuilder.utils.FieldUtils;

import java.util.Map;
import java.util.Set;

public class TextFieldBuilder extends AbstractFieldBuilder {

    private String value;
    private Integer minLength;
    private Integer maxLength;
    private Boolean multiLine;
    private Set<String> cssClasses;
    private Map<String, String> dataAttributes;

    public TextFieldBuilder(Form parentForm) {
        super(parentForm);
    }

    public TextFieldBuilder(Form parentForm, String name) {
        super(parentForm, name);
    }

    public TextFieldBuilder(Form parentForm, String name, String label, String value, Boolean multiLine) {
        super(parentForm, name, label);
        this.value = value;
        this.multiLine = multiLine;
    }

    public TextFieldBuilder(Form parentForm, String name, String label, String value, Boolean multiLine, Integer maxLength) {
        super(parentForm, name, label);
        this.value = value;
        this.multiLine = multiLine;
        this.maxLength = maxLength;
    }

    public TextFieldBuilder(Form parentForm, String name, String label, String value, Integer minLength,
                            Integer maxLength, Boolean multiLine) {
        super(parentForm, name, label);
        this.value = value;
        this.minLength = minLength;
        this.maxLength = maxLength;
        this.multiLine = multiLine;
    }

    public String getValue() {
        return value;
    }

    public Integer getMinLength() {
        return minLength;
    }

    public Integer getMaxLength() {
        return maxLength;
    }

    public Boolean getMultiLine() {
        return multiLine;
    }

    public Set<String> getCssClasses() {
        return cssClasses;
    }

    public Map<String, String> getDataAttributes() {
        return dataAttributes;
    }

    @Override
    public AbstractField build() {
        return new TextField(
                FieldUtils.getDefaultFieldConfiguration(),
                getParentForm(),
                getName(),
                getLabel(),
                value,
                multiLine
        );

        /*StringBuilder htmlBuilder = new StringBuilder(
                (multiLine) ? "<textarea " : "<input ");

        buildCommonAttributes(htmlBuilder);
        buildClasses(htmlBuilder);
        buildDataAttributes(htmlBuilder);
        buildConstraints(htmlBuilder);

        if (multiLine) {
            htmlBuilder.append(">");
            if (value != null) {
                htmlBuilder.append(value);
            }
        }

        htmlBuilder.append((multiLine) ? "</textarea>" : "/>");
        return htmlBuilder.toString();*/
    }

    /*private void buildCommonAttributes(StringBuilder htmlBuilder) {
        if (getId() != null) {
            htmlBuilder.append(String.format("id=\"%s\" ", getId()));
        }
        if (getName() != null) {
            htmlBuilder.append(String.format("name=\"%s\" ", getId()));
        }
        if (value != null && !multiLine) {
            htmlBuilder.append(String.format("value=\"%s\" ", value));
        }
    }

    private void buildClasses(StringBuilder htmlBuilder) {
        if (cssClasses == null || cssClasses.size() == 0) {
            return;
        }
        String cssClassesString = StringUtils.join(cssClasses.toArray(), " ");
        htmlBuilder.append(String.format("class=\"%s\" ", cssClassesString));
    }

    private void buildDataAttributes(StringBuilder htmlBuilder) {
        if (dataAttributes == null || dataAttributes.size() == 0) {
            return;
        }
        for (Map.Entry<String, String> dataAttribute : dataAttributes.entrySet()) {
            htmlBuilder.append(String.format("%s=\"%s\" ", dataAttribute.getKey(), dataAttribute.getValue()));
        }
    }

    private void buildConstraints(StringBuilder htmlBuilder) {
        boolean required = (minLength >= 0 || maxLength >= 0);
        //noinspection StringBufferReplaceableByString
        String pattern = new StringBuilder("{")
                .append((minLength >= 0) ? minLength : "")
                .append(",")
                .append((maxLength >= 0) ? maxLength : "")
                .append("}")
                .toString();

        if (pattern.length() > 0) {
            htmlBuilder.append(String.format("pattern=\"%s\" ", pattern));
        }
        if (required) {
            htmlBuilder.append(String.format("required=\"required\" "));
        }
    }*/
}

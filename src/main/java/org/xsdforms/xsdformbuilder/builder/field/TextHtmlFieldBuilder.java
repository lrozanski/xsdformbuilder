package org.xsdforms.xsdformbuilder.builder.field;

public class TextHtmlFieldBuilder extends HtmlFieldBuilder {

    private String value;
    private Integer minLength;
    private Integer maxLength;
    private Boolean multiLine;

    public TextHtmlFieldBuilder() {
    }

    public TextHtmlFieldBuilder(String name) {
        super(name);
    }

    public TextHtmlFieldBuilder(String name, String label, String value, Boolean multiLine) {
        super(name, label);
        this.value = value;
        this.multiLine = multiLine;
    }

    public TextHtmlFieldBuilder(String name, String label, String value, Boolean multiLine, Integer maxLength) {
        super(name, label);
        this.value = value;
        this.multiLine = multiLine;
        this.maxLength = maxLength;
    }

    public TextHtmlFieldBuilder(String name, String label, String value, Integer minLength,
                                Integer maxLength, Boolean multiLine) {
        super(name, label);
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

    @Override
    public String build() {
        StringBuilder htmlBuilder = new StringBuilder(
                (multiLine) ? "<textarea " : "<input ");

        buildCommonAttributes(htmlBuilder);
        buildClasses(htmlBuilder);
        buildDataAttributes(htmlBuilder);
        buildConstraints(htmlBuilder);

        // TODO : Add cssClasses
        // TODO : Add dataAttributes

        if (multiLine) {
            htmlBuilder.append(">");
            if (value != null) {
                htmlBuilder.append(value);
            }
        }
        htmlBuilder.append((multiLine) ? "</textarea>" : "/>");
        return htmlBuilder.toString();
    }

    private void buildCommonAttributes(StringBuilder htmlBuilder) {
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

    }

    private void buildDataAttributes(StringBuilder htmlBuilder) {

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
    }
}

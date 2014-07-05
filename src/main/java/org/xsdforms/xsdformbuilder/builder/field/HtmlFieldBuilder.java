package org.xsdforms.xsdformbuilder.builder.field;

public abstract class HtmlFieldBuilder extends AbstractFieldBuilder {

    private String id;
    private String name;
    private String label;

    protected HtmlFieldBuilder() {
    }

    protected HtmlFieldBuilder(String id) {
        this.id = id;
    }

    public HtmlFieldBuilder(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public HtmlFieldBuilder(String id, String name, String label) {
        this.id = id;
        this.name = name;
        this.label = label;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLabel() {
        return label;
    }

    public HtmlFieldBuilder withId(String id) {
        this.id = id;
        return this;
    }

    public HtmlFieldBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public HtmlFieldBuilder withLabel(String label) {
        this.label = label;
        return this;
    }
}

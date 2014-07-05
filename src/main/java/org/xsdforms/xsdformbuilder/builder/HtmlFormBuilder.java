package org.xsdforms.xsdformbuilder.builder;

import org.xsdforms.xsdformbuilder.form.Form;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class HtmlFormBuilder extends AbstractBuilder {

    private String id;
    private String name;
    private Set<String> cssClasses;
    private Map<String, String> dataAttributes;
    private String action;
    private String method;

    public HtmlFormBuilder() {
    }

    public HtmlFormBuilder(Form form) {
        this.id = form.getId();
        this.name = form.getName();
        this.cssClasses = form.getCssClasses();
        this.dataAttributes = form.getDataAttributes();
        this.action = form.getAction();
        this.method = form.getMethod();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<String> getCssClasses() {
        return cssClasses;
    }

    public Map<String, String> getDataAttributes() {
        return dataAttributes;
    }

    public String getAction() {
        return action;
    }

    public String getMethod() {
        return method;
    }

    public HtmlFormBuilder withId(String id) {
        this.id = id;
        return this;
    }

    public HtmlFormBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public HtmlFormBuilder withCssClass(String cssClass) {
        if (cssClasses == null) {
            cssClasses = new LinkedHashSet<>();
        }
        cssClasses.add(cssClass);
        return this;
    }

    public HtmlFormBuilder withCssClasses(Collection<String> cssClasses) {
        this.cssClasses = new LinkedHashSet<>(cssClasses);
        return this;
    }

    public HtmlFormBuilder withDataAttribute(String name, String value) {
        if (dataAttributes == null) {
            dataAttributes = new LinkedHashMap<>();
        }
        dataAttributes.put(name, value);
        return this;
    }

    public HtmlFormBuilder withDataAttributes(Map<String, String> dataAttributes) {
        this.dataAttributes = new LinkedHashMap<>();
        if (dataAttributes.size() > 0) {
            for (Map.Entry<String, String> dataAttribute : dataAttributes.entrySet()) {
                this.dataAttributes.put(dataAttribute.getKey(), dataAttribute.getValue());
            }
        }
        return this;
    }

    public HtmlFormBuilder withAction(String action) {
        this.action = action;
        return this;
    }

    public HtmlFormBuilder withMethod(String method) {
        this.method = method;
        return this;
    }

    @Override
    public String build() {
        return null;
    }
}

package org.xsdforms.xsdformbuilder.builder;

import org.apache.commons.lang.StringUtils;
import org.xsdforms.xsdformbuilder.builder.field.AbstractFieldBuilder;
import org.xsdforms.xsdformbuilder.form.Form;
import org.xsdforms.xsdformbuilder.form.field.AbstractField;
import org.xsdforms.xsdformbuilder.utils.FormUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FormBuilder extends AbstractBuilder<Form> {

    private String id;
    private String name;
    private Set<String> cssClasses;
    private Map<String, String> dataAttributes;
    private String action;
    private String method;
    private List<AbstractField> fields;

    public FormBuilder() {
    }

    public FormBuilder(Form form) {
        this.id = form.getId();
        this.name = form.getName();
        this.cssClasses = form.getCssClasses();
        this.dataAttributes = form.getDataAttributes();
        this.action = form.getAction();
        this.method = form.getMethod();
        this.fields = form.getFields();
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

    public FormBuilder withId(String id) {
        this.id = id;
        return this;
    }

    public FormBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public FormBuilder withCssClass(String cssClass) {
        if (cssClasses == null) {
            cssClasses = new LinkedHashSet<>();
        }
        cssClasses.add(cssClass);
        return this;
    }

    public FormBuilder withCssClasses(Collection<String> cssClasses) {
        this.cssClasses.addAll(new LinkedHashSet<>(cssClasses));
        return this;
    }

    public FormBuilder withDataAttribute(String name, String value) {
        if (dataAttributes == null) {
            dataAttributes = new LinkedHashMap<>();
        }
        dataAttributes.put(name, value);
        return this;
    }

    public FormBuilder withDataAttributes(Map<String, String> dataAttributes) {
        this.dataAttributes = new LinkedHashMap<>();
        if (dataAttributes.size() > 0) {
            for (Map.Entry<String, String> dataAttribute : dataAttributes.entrySet()) {
                this.dataAttributes.put(dataAttribute.getKey(), dataAttribute.getValue());
            }
        }
        return this;
    }

    public FormBuilder withAction(String action) {
        this.action = action;
        return this;
    }

    public FormBuilder withMethod(String method) {
        this.method = method;
        return this;
    }

    public FormBuilder withFields(Collection<AbstractField> formFields) {
        initFields();
        this.fields.addAll(formFields);
        return this;
    }

    public FormBuilder withField(AbstractField formField) {
        initFields();
        this.fields.add(formField);
        return this;
    }

    public FormBuilder withField(AbstractFieldBuilder fieldBuilder) {
        initFields();
        this.fields.add(fieldBuilder.build());
        return this;
    }

    private void initFields() {
        if (fields == null) {
            fields = new ArrayList<>();
        }
    }

    @Override
    public Form build() {
        Form form = new Form(FormUtils.getDefaultFormConfiguration());
        form.setId((id == null) ? form.getId() : id);
        form.setName((StringUtils.isBlank(name)) ? form.getName() : name);
        form.setCssClasses((cssClasses == null) ? form.getCssClasses() : cssClasses);
        form.setAction((action == null) ? form.getAction() : action);
        form.setDataAttributes((dataAttributes == null) ? form.getDataAttributes() : dataAttributes);
        form.setMethod((method == null) ? form.getMethod() : method);
        form.setFields((fields == null) ? form.getFields() : fields);

        return form;
    }
}

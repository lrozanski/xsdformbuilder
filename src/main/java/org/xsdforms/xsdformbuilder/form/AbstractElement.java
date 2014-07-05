package org.xsdforms.xsdformbuilder.form;

import org.apache.maven.shared.utils.StringUtils;
import org.xsdforms.xsdformbuilder.configuration.AbstractConfiguration;
import org.xsdforms.xsdformbuilder.configuration.impl.FormPropertyNames;

import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public abstract class AbstractElement implements Serializable {

    private static final Long serialVersionUID = -1L;
    protected static final String ERROR_CODE_MISSING_COLON = "error.configuration.form.missingColon";
    protected static final String ERROR_CODE_MISSING_COLON_DEFAULT_VALUE = "Missing colon in property value.";

    private AbstractConfiguration configuration;
    private String id;
    private String name;
    private Set<String> cssClasses = new LinkedHashSet<>();
    /**
     * Data attributes of the form element. The string "data-" is always prepended automatically.
     */
    private Map<String, String> dataAttributes = new LinkedHashMap<>();

    protected AbstractElement(AbstractConfiguration configuration) {
        this.configuration = configuration;
    }

    public AbstractConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(AbstractConfiguration configuration) {
        this.configuration = configuration;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getCssClasses() {
        return cssClasses;
    }

    public void setCssClasses(Set<String> cssClasses) {
        this.cssClasses = cssClasses;
    }

    public Map<String, String> getDataAttributes() {
        return dataAttributes;
    }

    public void setDataAttributes(Map<String, String> dataAttributes) {
        this.dataAttributes = dataAttributes;
    }

    protected void validateProperties() {
        Map<String, String> propertyErrors = new LinkedHashMap<>();

        validateDataAttributes(propertyErrors);
    }

    private void validateDataAttributes(Map<String, String> propertyErrors) {
        Properties properties = getConfiguration().getProperties();
        String[] propertyEntries = properties.getProperty(
                FormPropertyNames.DATA_ATTRIBUTES.getValue(), "").split(",");
        if (propertyEntries.length > 0) {
            for (String propertyEntry : propertyEntries) {
                String[] entry = propertyEntry.split(":");
                if (entry.length < 2) {
                    propertyErrors.put(
                            FormPropertyNames.DATA_ATTRIBUTES.getValue(),
                            getConfiguration().getMessages().getProperty(
                                    ERROR_CODE_MISSING_COLON,
                                    ERROR_CODE_MISSING_COLON_DEFAULT_VALUE
                            )
                    );
                }
            }
        }
    }

    /**
     * Parses properties and updates current configuration.
     */
    protected void parseProperties() {
        Properties properties = configuration.getProperties();

        String idProperty = properties.getProperty(FormPropertyNames.ID.getValue(), null);
        String nameProperty = properties.getProperty(FormPropertyNames.NAME.getValue(), null);
        String cssClassesProperty = properties.getProperty(FormPropertyNames.CSS_CLASSES.getValue(), null);
        String dataAttributesProperty = properties.getProperty(FormPropertyNames.DATA_ATTRIBUTES.getValue(), null);

        setId(idProperty);
        setName(nameProperty);
        if (StringUtils.isNotBlank(cssClassesProperty)) {
            setCssClasses(new LinkedHashSet<>(Arrays.asList(cssClassesProperty.split(","))));
        }
        if (StringUtils.isNotBlank(dataAttributesProperty)) {
            String[] entries = dataAttributesProperty.split(":");
            if (entries.length > 0) {
                getDataAttributes().put(entries[0], entries[1]);
            }
        }
    }
}

package org.xsdforms.xsdformbuilder.form;

import org.xsdforms.xsdformbuilder.configuration.AbstractConfiguration;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractElement implements Serializable {

    private static final Long serialVersionUID = -1L;
    protected static final String ERROR_CODE_MISSING_COLON = "error.configuration.form.missingColon";
    protected static final String ERROR_CODE_MISSING_COLON_DEFAULT_VALUE = "Missing colon in property value";

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AbstractElement that = (AbstractElement) o;

        if (id != null ? !id.equals(that.id) : that.id != null) {
            return false;
        }
        if (name != null ? !name.equals(that.name) : that.name != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}

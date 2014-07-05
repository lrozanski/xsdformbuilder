package org.xsdforms.xsdformbuilder.configuration;

import java.io.Serializable;
import java.util.Properties;

public abstract class AbstractConfiguration implements Serializable, Configurable, Translatable {

    private static final Long serialVersionUID = -1L;

    private Properties properties;
    private Properties messages;

    public AbstractConfiguration(Properties properties) {
        this.properties = properties;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Properties getMessages() {
        return messages;
    }

    public void setMessages(Properties messages) {
        this.messages = messages;
    }
}

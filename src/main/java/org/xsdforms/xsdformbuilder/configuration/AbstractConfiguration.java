package org.xsdforms.xsdformbuilder.configuration;

import org.xsdforms.xsdformbuilder.utils.TranslationUtils;

import java.io.Serializable;
import java.util.Locale;
import java.util.Properties;

public abstract class AbstractConfiguration implements Serializable, Configurable, Translatable {

    private static final Long serialVersionUID = -1L;

    private Properties properties;
    private Properties messages;

    public AbstractConfiguration(Properties properties, Locale locale) {
        this.properties = properties;
        this.messages = TranslationUtils.getDefaultMessagesForLocale(locale);
    }

    public AbstractConfiguration(Properties properties, Properties messages) {
        this.properties = properties;
        this.messages = messages;
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

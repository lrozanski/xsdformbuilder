package org.xsdforms.xsdformbuilder.configuration;

import org.xsdforms.xsdformbuilder.utils.TranslationUtils;

import java.io.Serializable;
import java.util.Locale;
import java.util.Properties;

public abstract class AbstractConfiguration implements Serializable, Translatable {

    private static final Long serialVersionUID = -1L;

    private Properties messages;

    public AbstractConfiguration(Locale locale) {
        this.messages = TranslationUtils.getDefaultMessagesForLocale(locale);
    }

    public AbstractConfiguration(Properties messages) {
        this.messages = messages;
    }

    public Properties getMessages() {
        return messages;
    }

    public void setMessages(Properties messages) {
        this.messages = messages;
    }
}

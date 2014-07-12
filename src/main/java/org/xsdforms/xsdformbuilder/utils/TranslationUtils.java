package org.xsdforms.xsdformbuilder.utils;

import org.xsdforms.xsdformbuilder.exception.FormBuilderRuntimeException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;

public final class TranslationUtils {

    private TranslationUtils() {
    }

    public static Properties getDefaultMessagesForLocale(Locale locale) {
        Properties messages = new Properties();
        String filename = String.format("messages/messages_%s.properties", locale.getLanguage());
        InputStream inputStream = TranslationUtils.class.getClassLoader().getResourceAsStream(filename);
        try {
            messages.load(inputStream);
        } catch (IOException e) {
            throw new FormBuilderRuntimeException(e);
        }

        return messages;
    }
}

package org.xsdforms.xsdformbuilder.utils;

import org.xsdforms.xsdformbuilder.form.AbstractForm;
import org.xsdforms.xsdformbuilder.form.field.AbstractField;

public final class FormUtils {

    private FormUtils() {
    }

    public static String getCssSelector(AbstractForm form) {
        return String.format("#%s", form.getId());
    }

    public static String getCssSelector(AbstractField field) {
        String formSelector = getCssSelector(field.getParentForm());
        return String.format("%s #%s", formSelector, field.getId());
    }
}

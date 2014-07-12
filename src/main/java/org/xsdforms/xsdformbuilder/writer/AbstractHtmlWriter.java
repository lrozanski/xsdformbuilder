package org.xsdforms.xsdformbuilder.writer;

import org.xsdforms.xsdformbuilder.form.AbstractElement;

public abstract class AbstractHtmlWriter<T extends AbstractElement> {

    private StringBuilder output = new StringBuilder();

    public abstract void write(T... values);

    public String flush() {
        final String outputString = output.toString();
        output = null;
        return outputString;
    }

    protected StringBuilder getOutput() {
        return output;
    }
}

package org.xsdforms.xsdformbuilder.writer.field;

public class FieldWriterLabelStep extends AbstractFieldWriterStep {

    public FieldWriterLabelStep(StringBuilder output) {
        super(output);
    }

    public FieldWriterStartElementStep writeLabel(String id, String label) {
        getOutput().append(String.format("<label for=\"%s\">%s</label>", id, label));
        return new FieldWriterStartElementStep(getOutput());
    }
}

package org.xsdforms.xsdformbuilder.exception;

public class FormBuilderRuntimeException extends RuntimeException {

    public FormBuilderRuntimeException() {
    }

    public FormBuilderRuntimeException(String message) {
        super(message);
    }

    public FormBuilderRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public FormBuilderRuntimeException(Throwable cause) {
        super(cause);
    }
}

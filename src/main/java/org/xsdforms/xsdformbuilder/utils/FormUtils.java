package org.xsdforms.xsdformbuilder.utils;

import org.apache.commons.lang.StringUtils;
import org.xsdforms.xsdformbuilder.configuration.impl.FormConfiguration;
import org.xsdforms.xsdformbuilder.exception.FormBuilderRuntimeException;
import org.xsdforms.xsdformbuilder.form.AbstractForm;
import org.xsdforms.xsdformbuilder.form.Form;
import org.xsdforms.xsdformbuilder.form.field.AbstractField;
import org.xsdforms.xsdformbuilder.form.field.NumberField;
import org.xsdforms.xsdformbuilder.form.field.TextField;
import org.xsdforms.xsdformbuilder.schema.Annotated;
import org.xsdforms.xsdformbuilder.schema.Element;
import org.xsdforms.xsdformbuilder.schema.ExplicitGroup;
import org.xsdforms.xsdformbuilder.schema.LocalComplexType;
import org.xsdforms.xsdformbuilder.schema.Restriction;
import org.xsdforms.xsdformbuilder.schema.SimpleType;

import javax.xml.bind.JAXBElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class FormUtils {

    private FormUtils() {
    }

    public static FormConfiguration getDefaultFormConfiguration() {
        return new FormConfiguration();
    }

    public static String getCssSelector(AbstractForm form) {
        return String.format("#%s", form.getId());
    }

    public static String getCssSelector(AbstractField field) {
        String formSelector = getCssSelector(field.getParentForm());
        return String.format("%s #%s", formSelector, field.getId());
    }

    public static List<AbstractField> parseElement(Map<String, Annotated> typeMap, Form parentForm, Element element) {
        List<AbstractField> fields = new ArrayList<>();

        if (element.getType() != null) {
            fields.add(parseElementType(parentForm, element));
        } else if (element.getSimpleType() != null) {

        } else if (element.getComplexType() != null) {
            fields.addAll(parseComplexType(typeMap, parentForm, element.getComplexType()));
        }

        return fields;
    }

    private static List<AbstractField> parseComplexType(Map<String, Annotated> typeMap, Form parentForm,
                                                        LocalComplexType complexType) {
        List<AbstractField> fields = new ArrayList<>();

        if (complexType.getSequence() != null) {
            ExplicitGroup sequence = complexType.getSequence();
            List<Object> children = sequence.getParticle();
            if (children.size() == 0) {
                return fields;
            }
            for (Object child : children) {
                if (child instanceof JAXBElement) {
                    Object element = ((JAXBElement) child).getValue();
                    if (element instanceof Element) {
                        fields.addAll(parseElement(typeMap, parentForm, (Element) element));
                    }
                }
            }
        }

        return fields;
    }

    private static AbstractField parseElementType(Form parentForm, Element element) {
        String type = element.getType().getLocalPart();
        if (StringUtils.isBlank(type)) {
            throw new FormBuilderRuntimeException("Element type is undefined");
        }

        switch (type) {
            case FieldTypeConstants.XS_STRING:
                return createTextField(parentForm, element);
            case FieldTypeConstants.XS_INT:
                return createIntegerField(parentForm, element);
            default:
                return null;
        }
    }

    private static AbstractField createTextField(Form parentForm, Element element) {
        return new TextField(
                FieldUtils.getDefaultFieldConfiguration(),
                parentForm,
                element.getName(),
                element.getName(),
                "",
                false
        );
    }

    private static AbstractField createIntegerField(Form parentForm, Element element) {
        return new NumberField(
                FieldUtils.getDefaultFieldConfiguration(),
                parentForm,
                element.getName(),
                element.getName(),
                0.0,
                0
        );
    }

    public static void parseSimpleType(SimpleType simpleType) {
        Restriction restriction = simpleType.getRestriction();
        if (restriction != null) {

        }
    }
}

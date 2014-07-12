package org.xsdforms.xsdformbuilder.factory;

import org.xsdforms.xsdformbuilder.exception.FormBuilderRuntimeException;
import org.xsdforms.xsdformbuilder.form.Form;
import org.xsdforms.xsdformbuilder.form.field.AbstractField;
import org.xsdforms.xsdformbuilder.schema.Annotated;
import org.xsdforms.xsdformbuilder.schema.ComplexType;
import org.xsdforms.xsdformbuilder.schema.OpenAttrs;
import org.xsdforms.xsdformbuilder.schema.Schema;
import org.xsdforms.xsdformbuilder.schema.SimpleType;
import org.xsdforms.xsdformbuilder.schema.TopLevelElement;
import org.xsdforms.xsdformbuilder.utils.FormUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class FormFactory {

    private static FormFactory instance;

    private static final String NO_ROOT_ELEMENT_FOUND_EXCEPTION = "No root element found";

    private FormFactory() {
    }

    public static FormFactory getInstance() {
        if (instance == null) {
            instance = new FormFactory();
        }
        return instance;
    }

    public Form getForm(InputStream inputStream) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance("org.xsdforms.xsdformbuilder.schema");
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            JAXBElement<Schema> topLevelElement = unmarshaller.unmarshal(
                    new StreamSource(inputStream), Schema.class);
            TopLevelElement rootElement = getRootElement(topLevelElement);
            Map<String, Annotated> typeMap = getAllTypes(topLevelElement);

            Form form = new Form(FormUtils.getDefaultFormConfiguration());
            List<AbstractField> formFields = FormUtils.parseElement(typeMap, form, rootElement);
            form.setFields(formFields);

            return form;
        } catch (JAXBException e) {
            throw new FormBuilderRuntimeException(e);
        }
    }

    private TopLevelElement getRootElement(JAXBElement<Schema> topLevelElement) {
        TopLevelElement rootElement = null;
        for (OpenAttrs element : topLevelElement.getValue().getSimpleTypeOrComplexTypeOrGroup()) {
            if (element.getClass().isAssignableFrom(TopLevelElement.class)) {
                rootElement = (TopLevelElement) element;
                break;
            }
        }
        if (rootElement == null) {
            throw new FormBuilderRuntimeException(NO_ROOT_ELEMENT_FOUND_EXCEPTION);
        }
        return rootElement;
    }

    private Map<String, Annotated> getAllTypes(JAXBElement<Schema> topLevelElement) {
        Map<String, Annotated> typeMap = new HashMap<>();
        for (OpenAttrs element : topLevelElement.getValue().getSimpleTypeOrComplexTypeOrGroup()) {
            if (element instanceof SimpleType) {
                typeMap.put(((SimpleType) element).getName(), (SimpleType) element);
            } else if (element instanceof ComplexType) {
                typeMap.put(((ComplexType) element).getName(), (ComplexType) element);
            }
        }

        return typeMap;
    }
}

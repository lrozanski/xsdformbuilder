package org.xsdforms.xsdformbuilder.factory;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.junit.Test;
import org.xsdforms.xsdformbuilder.form.Form;
import org.xsdforms.xsdformbuilder.form.field.NumberField;
import org.xsdforms.xsdformbuilder.form.field.TextField;
import org.xsdforms.xsdformbuilder.utils.VelocityUtils;

import java.io.InputStream;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class FormFactoryTest {

    private static final Logger LOGGER = Logger.getLogger(FormFactoryTest.class);

    @Test
    public void testGetForm() throws Exception {
        try (InputStream inputStream = FormFactoryTest.class.getClassLoader().getResourceAsStream("xsd/getFormTest.xsd")) {
            Form form = FormFactory.getInstance().getForm(inputStream);
            LOGGER.debug(String.format("Form fields: %s", form.getFields().size()));
            assertTrue(form.getFields() != null && form.getFields().size() > 0);

            form.setAction("#");
            form.setDataAttributes(new HashMap<String, String>() {{
                put("text", "value");
                put("text2", "value2");
            }});
            ((TextField)form.getFields().get(0)).setRequired(true);
            ((TextField)form.getFields().get(0)).setMinLength(5);
            ((TextField)form.getFields().get(0)).setMaxLength(8);

            ((NumberField)form.getFields().get(2)).setMinValue(1);
            ((NumberField)form.getFields().get(2)).setMaxValue(8);
            ((NumberField)form.getFields().get(2)).setValue(1.5);
            ((NumberField)form.getFields().get(2)).setDecimalPlaces(2);

            Map<Object, Object> data = new HashMap<>();
            data.put("form", form);
            String html = VelocityUtils.renderTemplateToString("templates/default.xhtml", data);
            LOGGER.debug(html);
        }
    }
}

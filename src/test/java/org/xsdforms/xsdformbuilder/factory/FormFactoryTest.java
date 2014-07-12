package org.xsdforms.xsdformbuilder.factory;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.tidy.Node;
import org.w3c.tidy.Tidy;
import org.xsdforms.xsdformbuilder.form.Form;
import org.xsdforms.xsdformbuilder.writer.FormHtmlWriter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.StringWriter;

import static org.junit.Assert.assertTrue;

public class FormFactoryTest {

    private static final Logger LOGGER = Logger.getLogger(FormFactoryTest.class);

    @Test
    public void testGetForm() throws Exception {
        try (InputStream inputStream = FormFactoryTest.class.getClassLoader().getResourceAsStream("xsd/getFormTest.xsd")) {
            Form form = FormFactory.getInstance().getForm(inputStream);
            LOGGER.debug(String.format("Form fields: %s", form.getFields().size()));
            assertTrue(form.getFields() != null && form.getFields().size() > 0);

            FormHtmlWriter formHtmlWriter = new FormHtmlWriter();
            formHtmlWriter.write(form);
            String formHtml = formHtmlWriter.flush();
            LOGGER.debug(formHtml);
            assertTrue(StringUtils.isNotBlank(formHtml));
        }
    }
}
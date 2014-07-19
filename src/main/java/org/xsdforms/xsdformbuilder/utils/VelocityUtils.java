package org.xsdforms.xsdformbuilder.utils;

import org.apache.commons.lang.StringUtils;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.xsdforms.xsdformbuilder.exception.FormBuilderRuntimeException;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

public final class VelocityUtils {

    private static VelocityEngine velocityEngine;

    static {
        velocityEngine = new VelocityEngine();
        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        velocityEngine.init();
    }

    private VelocityUtils() {
    }

    public static VelocityEngine getVelocityEngine() {
        return velocityEngine;
    }

    public static String renderTemplateToString(String templateLocation, Map<Object, Object> data) {
        StringWriter writer = new StringWriter();
        VelocityContext velocityContext = new VelocityContext(data);
        velocityEngine.mergeTemplate(templateLocation, "UTF-8", velocityContext, writer);

        return prettyPrint(writer.toString());
    }

    private static String prettyPrint(final String xml) {

        if (StringUtils.isBlank(xml)) {
            throw new RuntimeException("xml was null or blank in prettyPrint()");
        }

        final StringWriter sw;

        try {
            final OutputFormat format = OutputFormat.createPrettyPrint();
            format.setOmitEncoding(true);
            format.setSuppressDeclaration(true);
            format.setIndentSize(4);
            final org.dom4j.Document document = DocumentHelper.parseText(xml);
            sw = new StringWriter();
            final XMLWriter writer = new XMLWriter(sw, format);
            writer.write(document);
        } catch (DocumentException | IOException e) {
            throw new FormBuilderRuntimeException(e);
        }
        return sw.toString();
    }
}

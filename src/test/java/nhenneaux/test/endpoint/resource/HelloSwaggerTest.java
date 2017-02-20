package nhenneaux.test.endpoint.resource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.common.io.Files;
import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.models.Swagger;
import io.swagger.util.Json;
import nhenneaux.test.swagger.ext.EnumModelAwareBeanConfig;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertEquals;


public class HelloSwaggerTest {

    @Test
    public void testEnum() throws IOException {
        final BeanConfig beanConfig = new EnumModelAwareBeanConfig();
        beanConfig.setResourcePackage(HelloSwagger.class.getPackage().getName());
        beanConfig.setScan();
        final Swagger swagger = beanConfig.getSwagger();
        final String s = Json.pretty().writeValueAsString(swagger);

        assertEquals(
                Files.toString(new File(getClass().getResource("/expected.json").getFile()), StandardCharsets.UTF_8),
                s
        );
    }
}
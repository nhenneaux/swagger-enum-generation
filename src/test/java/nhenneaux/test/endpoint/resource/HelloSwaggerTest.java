package nhenneaux.test.endpoint.resource;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.models.Swagger;
import io.swagger.util.Json;
import nhenneaux.test.swagger.ext.EnumModelAwareBeanConfig;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class HelloSwaggerTest {

    @Test
    public void testEnum() throws JsonProcessingException {
        final BeanConfig beanConfig = new EnumModelAwareBeanConfig();
        beanConfig.setResourcePackage(HelloSwagger.class.getPackage().getName());
        beanConfig.setScan();
        final Swagger swagger = beanConfig.getSwagger();
        final String s = Json.pretty().writeValueAsString(swagger);

        assertEquals(
                "{\n" +
                        "  \"swagger\" : \"2.0\",\n" +
                        "  \"info\" : { },\n" +
                        "  \"tags\" : [ {\n" +
                        "    \"name\" : \"hello\"\n" +
                        "  } ],\n" +
                        "  \"paths\" : {\n" +
                        "    \"/helloSwagger/getUniqueUsers\" : {\n" +
                        "      \"get\" : {\n" +
                        "        \"tags\" : [ \"hello\" ],\n" +
                        "        \"summary\" : \"Get all unique customers\",\n" +
                        "        \"description\" : \"Get all customers matching the given search string.\",\n" +
                        "        \"operationId\" : \"getUniqueUsers\",\n" +
                        "        \"produces\" : [ \"application/json\" ],\n" +
                        "        \"parameters\" : [ {\n" +
                        "          \"name\" : \"search\",\n" +
                        "          \"in\" : \"query\",\n" +
                        "          \"description\" : \"The search string is used to find customer by their name. Not case sensitive.\",\n" +
                        "          \"required\" : false,\n" +
                        "          \"type\" : \"string\"\n" +
                        "        }, {\n" +
                        "          \"name\" : \"limit\",\n" +
                        "          \"in\" : \"query\",\n" +
                        "          \"description\" : \"Limits the size of the result set\",\n" +
                        "          \"required\" : false,\n" +
                        "          \"type\" : \"integer\",\n" +
                        "          \"default\" : 50,\n" +
                        "          \"format\" : \"int32\"\n" +
                        "        } ],\n" +
                        "        \"responses\" : {\n" +
                        "          \"200\" : {\n" +
                        "            \"description\" : \"successful operation\",\n" +
                        "            \"schema\" : {\n" +
                        "              \"type\" : \"array\",\n" +
                        "              \"uniqueItems\" : true,\n" +
                        "              \"items\" : {\n" +
                        "                \"$ref\" : \"#/definitions/User\"\n" +
                        "              }\n" +
                        "            }\n" +
                        "          }\n" +
                        "        }\n" +
                        "      }\n" +
                        "    }\n" +
                        "  },\n" +
                        "  \"definitions\" : {\n" +
                        "    \"SynchronizationStatus\" : {\n" +
                        "      \"description\" : \"The synchronization status with LDAP instance.\",\n" +
                        "      \"enum\" : [ \"UNKNOWN\", \"SYNC\", \"OFFLINE\", \"CONFLICT\" ],\n" +
                        "      \"type\" : \"string\"\n" +
                        "    },\n" +
                        "    \"User\" : {\n" +
                        "      \"type\" : \"object\",\n" +
                        "      \"properties\" : {\n" +
                        "        \"name\" : {\n" +
                        "          \"type\" : \"string\",\n" +
                        "          \"description\" : \"The user name\"\n" +
                        "        },\n" +
                        "        \"ldap1\" : {\n" +
                        "          \"$ref\" : \"#/definitions/SynchronizationStatus\"\n" +
                        "        },\n" +
                        "        \"ldap2\" : {\n" +
                        "          \"$ref\" : \"#/definitions/SynchronizationStatus\"\n" +
                        "        }\n" +
                        "      }\n" +
                        "    }\n" +
                        "  }\n" +
                        "}",
                s
        );
    }
}
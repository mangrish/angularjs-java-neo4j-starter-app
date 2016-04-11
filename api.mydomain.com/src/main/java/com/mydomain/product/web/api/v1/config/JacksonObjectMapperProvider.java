package com.mydomain.product.web.api.v1.config;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

/**
 * Created by markangrish on 11/06/2014.
 */
@Provider
public class JacksonObjectMapperProvider implements ContextResolver<ObjectMapper>
{
    final ObjectMapper objectMapper;

    public JacksonObjectMapperProvider()
    {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new Jdk8Module());
        objectMapper.configure(SerializationFeature.
                                       WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        objectMapper.disable(MapperFeature.USE_GETTERS_AS_SETTERS);
    }

    @Override
    public ObjectMapper getContext(Class<?> type)
    {
        return objectMapper;
    }
}

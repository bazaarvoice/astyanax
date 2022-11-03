package com.netflix.astyanax.serializers;

import java.io.ByteArrayInputStream;
import java.nio.ByteBuffer;

import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;

public class JacksonSerializer<T> extends AbstractSerializer<T> {

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
    private static final ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.getSerializationConfig().withSerializationInclusion(JsonSerialize.Inclusion.NON_EMPTY);
    }
    
    private final Class<T> clazz;

    public JacksonSerializer(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public ByteBuffer toByteBuffer(T entity) {
        try {
            byte[] bytes = mapper.writeValueAsBytes(entity);
            return ByteBuffer.wrap(bytes);
        } catch (Exception e) {
            throw new RuntimeException("Error serializing entity ", e);
        }
    }

    @Override
    public T fromByteBuffer(ByteBuffer byteBuffer) {
        try {
            return mapper.readValue(new ByteArrayInputStream(byteBuffer.array()), clazz);
        } catch (Exception e) {
            throw new RuntimeException("Error serializing entity ", e);
        }
    }
}

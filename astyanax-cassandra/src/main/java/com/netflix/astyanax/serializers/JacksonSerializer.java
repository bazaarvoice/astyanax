package com.netflix.astyanax.serializers;

import java.io.ByteArrayInputStream;
import java.nio.ByteBuffer;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonSerializer<T> extends AbstractSerializer<T> {
    private static final ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.getSerializationConfig().withPropertyInclusion(JsonInclude.Value.construct(JsonInclude.Include.NON_EMPTY,JsonInclude.Include.NON_EMPTY));
        mapper.enableDefaultTyping();
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

package com.itranswarp.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JsonReader {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static <T> T readJson(Object source, Object typeSpecifier) {
        try {
            if (source instanceof Reader) {
                if (typeSpecifier instanceof Class<?>) {
                    return OBJECT_MAPPER.readValue((Reader) source, (Class<T>) typeSpecifier);
                } else if (typeSpecifier instanceof TypeReference<?>) {
                    return OBJECT_MAPPER.readValue((Reader) source, (TypeReference<T>) typeSpecifier);
                }
            } else if (source instanceof InputStream) {
                if (typeSpecifier instanceof Class<?>) {
                    return OBJECT_MAPPER.readValue((InputStream) source, (Class<T>) typeSpecifier);
                } else if (typeSpecifier instanceof TypeReference<?>) {
                    return OBJECT_MAPPER.readValue((InputStream) source, (TypeReference<T>) typeSpecifier);
                }
            }
            throw new IllegalArgumentException("Unsupported source or type specifier");
        } catch (IOException e) {
            throw new RuntimeException("Error reading JSON", e);
        }
    }
}
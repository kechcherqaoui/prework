package com.enset.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public interface DataTransformationUtils {
     static String toJson(Object o){
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper
                  .writerWithDefaultPrettyPrinter()
                  .writeValueAsString(o);
        } catch (JsonProcessingException e) {
            return "{}";
        }
    }
}

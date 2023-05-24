package com.demo.api.utils;

import com.demo.api.dto.request.ResgristerRequestObject;
import com.demo.api.exception.TestContextException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;

import java.io.IOException;

public class ObjectMapperUtils {


    public static void main(String[] args) {
        String json ="{\"name_user\":\"an\",\"id_user\":1}";

        ResgristerRequestObject demo  =convertJSONStringToDTOClassByGson(json, ResgristerRequestObject.class );
        System.out.println("demo = " + demo);

    }
    public static <T> T convertJSONStringToDTOClassByGson(String jsonString, Class<T> clazz) {
        Gson builder = new Gson();
        return builder.fromJson(jsonString, clazz);
    }

    public static <T> T convertJSONStringToDTOClassByJackson(String jsonString, Class<T> clazz) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(jsonString, clazz);
        } catch (IOException var4) {
            String className = clazz.getSimpleName();
            throw new TestContextException(String.format("Error in mapping to response [%s] class. %s", className, var4.getMessage()), var4);
        }
    }

    public static String convertDTOClassToJSONStringGson(Object dtoObject) {
        try {
            Gson builder = new Gson();
            return builder.toJson(dtoObject);
        } catch (JsonIOException | UnsupportedOperationException | IllegalArgumentException var4) {
            throw new TestContextException("Error in convert DTO to JSON String", var4);
        }
    }

    public static String convertDTOClassToJSONStringJackson(Object dtoObject) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(dtoObject);
        } catch (IOException var4) {

            throw new TestContextException(String.format("Error in mapping to response [%s] class. %s", dtoObject, var4.getMessage()), var4);
        }
    }

}

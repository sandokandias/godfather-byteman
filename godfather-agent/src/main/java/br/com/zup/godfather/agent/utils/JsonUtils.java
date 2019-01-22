package br.com.zup.godfather.agent.utils;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializer;

import java.util.Base64;

public class JsonUtils {

    private static GsonBuilder builder = new GsonBuilder();
    private static Gson mapper;

    static {
        builder.registerTypeAdapter(byte[].class, (JsonSerializer<byte[]>) (bytes, type, jsonSerializationContext) -> new JsonPrimitive(Base64.getEncoder().encodeToString(bytes)));
        mapper = builder.create();
    }

    public static String write(Object obj) {
        return mapper.toJson(obj);
    }

    public static String read(byte[] bytes) {
        return mapper.toJson(bytes);
    }
}

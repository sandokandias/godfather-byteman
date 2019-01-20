package br.com.zup.godfather.agent.utils;


import com.google.gson.Gson;

public class JsonUtils {

    private static final Gson mapper = new Gson();

    public static String writeAsString(Object obj) {
        return mapper.toJson(obj);
    }
}

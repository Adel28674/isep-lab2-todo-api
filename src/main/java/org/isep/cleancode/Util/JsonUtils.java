package org.isep.cleancode.Util;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org.isep.cleancode.Model.Todo;

public class JsonUtils {
    private static final Gson gson = new Gson();

    public static String toJson(Object object){
        return gson.toJson(object);
    }

    public static Todo parseTodo(String body) {
        try {
            return gson.fromJson(body, Todo.class);
        } catch (JsonSyntaxException e) {
            throw new IllegalArgumentException("Invalid JSON format for Todo.");
        }
    }
}

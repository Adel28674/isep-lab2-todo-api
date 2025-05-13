package org.isep.cleancode.Util;

import com.google.gson.Gson;
import org.isep.cleancode.Todo;

public class Serializer {
    private static final Gson gson = new Gson();

    public static Todo todoSerializer(String body){
        return gson.fromJson(body, Todo.class);
    }
}

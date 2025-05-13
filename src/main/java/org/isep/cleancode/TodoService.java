package org.isep.cleancode;

import com.google.gson.Gson;
import org.isep.cleancode.Util.Serializer;

import java.util.ArrayList;
import java.util.List;

public class TodoService {
    private static final List<Todo> todos = new ArrayList<>();
    private static final Gson gson = new Gson();


    public TodoService() {
    }

    public static Object getAllTodos(){
        return gson.toJson(todos);
    }

    public static Todo addTodo(String body){
        boolean shorterThan64Chars = false;
        boolean nameAlreadyExists = false;
        boolean validDueDate = false;
        Todo newTodo = Serializer.todoSerializer(body);

        if(shorterThan64Chars){
            throw new IllegalArgumentException("Name exceed the number of chars accepted. MAXIMUM is 64 chars");
        }
        if (nameAlreadyExists){
            throw new IllegalArgumentException("Name already Exists");
        }
        if (validDueDate){
            throw new IllegalArgumentException("dueDate invalid");
        }
        todos.add(newTodo);
        return newTodo;
    }

}

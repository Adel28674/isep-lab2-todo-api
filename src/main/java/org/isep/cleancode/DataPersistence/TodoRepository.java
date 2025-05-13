package org.isep.cleancode.DataPersistence;

import org.isep.cleancode.Model.Todo;
import org.isep.cleancode.Util.JsonUtils;

import java.util.ArrayList;
import java.util.List;

public class TodoRepository {

    private static final List<Todo> todos = new ArrayList<>();

    public static Object getAllTodos(){
        return JsonUtils.toJson(todos);
    }

    public static void addTodo(Todo newTodo){
        todos.add(newTodo);
    }

    public static boolean doesAlreadyNameExists(String name){
        return todos.stream().anyMatch(todo -> todo.getName().equalsIgnoreCase(name));
    }

}

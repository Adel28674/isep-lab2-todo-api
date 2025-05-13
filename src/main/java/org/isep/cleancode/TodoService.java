package org.isep.cleancode;

import com.google.gson.JsonSyntaxException;
import org.isep.cleancode.Util.JsonUtils;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TodoService {
    private static final List<Todo> todos = new ArrayList<>();

    public TodoService() {
    }

    public static Object getAllTodos(){
        return JsonUtils.toJson(todos);
    }

    public static Todo addTodo(String body) throws IllegalArgumentException {
        Todo newTodo = JsonUtils.parseTodo(body);
        boolean longerThan64Chars = (newTodo.getName()!=null && newTodo.getName().length()>64);
        boolean validDueDate = newTodo.getDueDate()!=null && isValidDate(newTodo.getDueDate());

        if(longerThan64Chars){
            throw new IllegalArgumentException("Name exceed the number of chars accepted. MAXIMUM is 64 chars");
        }
        if (doesAlreadyNameExists(newTodo.getName())){
            throw new IllegalArgumentException("Name already Exists");
        }
        if (validDueDate){
            throw new IllegalArgumentException("dueDate invalid");
        }
        todos.add(newTodo);
        return newTodo;
    }

    public static boolean doesAlreadyNameExists(String name){
        return todos.stream().anyMatch(todo -> todo.getName().equalsIgnoreCase(name));
    }

    public static boolean isValidDate(Date dueDate){
        return dueDate.before(new Date());
    }

}

package org.isep.cleancode.Application;

import org.isep.cleancode.DataPersistence.TodoRepository;
import org.isep.cleancode.Model.Todo;
import org.isep.cleancode.Util.JsonUtils;

import java.util.Date;

public class TodoManager {
    private static TodoRepository todoRepository = new TodoRepository();

    public TodoManager() {
    }

    public static Object getAllTodos(){
        return todoRepository.getAllTodos();
    }

    public static Todo addTodo(String body) throws IllegalArgumentException {
        Todo newTodo = JsonUtils.parseTodo(body);
        boolean longerThan64Chars = (newTodo.getName()!=null && newTodo.getName().length()>64);
        boolean validDueDate = newTodo.getDueDate()!=null && isValidDate(newTodo.getDueDate());

        if(longerThan64Chars){
            throw new IllegalArgumentException("Name exceed the number of chars accepted. MAXIMUM is 64 chars");
        }
        if (todoRepository.doesAlreadyNameExists(newTodo.getName())){
            throw new IllegalArgumentException("Name already Exists");
        }
        if (validDueDate){
            throw new IllegalArgumentException("dueDate invalid");
        }
        todoRepository.addTodo(newTodo);
        return newTodo;
    }

    public static boolean isValidDate(Date dueDate){
        return dueDate.before(new Date());
    }

}

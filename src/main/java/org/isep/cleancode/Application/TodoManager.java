package org.isep.cleancode.Application;

import org.isep.cleancode.Model.Todo;
import org.isep.cleancode.Util.JsonUtils;

import java.util.Date;
import java.util.List;

public class TodoManager {
    private ITodoRepository todoRepository ;

    public TodoManager(ITodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    public List<Todo> getAllTodos(){
        return todoRepository.getAllTodos();
    }

    public Todo addTodo(String body) throws IllegalArgumentException {
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

    public boolean isValidDate(Date dueDate){
        return dueDate.before(new Date());
    }

}

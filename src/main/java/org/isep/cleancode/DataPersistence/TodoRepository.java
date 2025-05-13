package org.isep.cleancode.DataPersistence;

import org.isep.cleancode.Application.ITodoRepository;
import org.isep.cleancode.Model.Todo;
import org.isep.cleancode.Util.JsonUtils;

import java.util.ArrayList;
import java.util.List;

public class TodoRepository implements ITodoRepository {

    private static final List<Todo> todos = new ArrayList<>();


    @Override
    public void addTodo(Todo todo) {
        todos.add(todo);
    }

    @Override
    public List<Todo> getAllTodos() {
        return todos;
    }

    @Override
    public boolean doesAlreadyNameExists(String name) {
        return todos.stream().anyMatch(todo -> todo.getName().equalsIgnoreCase(name));
    }
}

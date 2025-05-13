package org.isep.cleancode.DataPersistence.inMemory;

import org.isep.cleancode.Application.ITodoRepository;
import org.isep.cleancode.Model.Todo;

import java.util.ArrayList;
import java.util.List;

public class TodoInMemoryRepository implements ITodoRepository {

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
    public boolean doesNameAlreadyExists(String name) {
        return todos.stream().anyMatch(todo -> todo.getName().equalsIgnoreCase(name));
    }
}

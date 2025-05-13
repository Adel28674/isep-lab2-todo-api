package org.isep.cleancode.Application;

import org.isep.cleancode.Model.Todo;

import java.util.List;

public interface ITodoRepository {
    void addTodo(Todo todo);
    List<Todo> getAllTodos();

    boolean doesAlreadyNameExists(String name);
}
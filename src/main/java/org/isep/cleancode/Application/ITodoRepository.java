package org.isep.cleancode.Application;

import org.isep.cleancode.DataPersistence.csvFile.TodoCsvFilesRepository;
import org.isep.cleancode.DataPersistence.inMemory.TodoInMemoryRepository;
import org.isep.cleancode.Model.Todo;

import java.util.List;

public interface ITodoRepository {
    void addTodo(Todo todo);
    List<Todo> getAllTodos();

    boolean doesNameAlreadyExists(String name);

    public static ITodoRepository getTodoRepository(String repo){
        switch (repo){
            case "MEMORY":
                return new TodoInMemoryRepository();

            case "CSV":
                return new TodoCsvFilesRepository();

            default:
                return new TodoInMemoryRepository();
        }
    }
}
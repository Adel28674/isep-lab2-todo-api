package org.isep.cleancode.DataPersistence.csvFile;

import org.isep.cleancode.Application.ITodoRepository;
import org.isep.cleancode.Model.Todo;
import org.isep.cleancode.Util.CSVSerializer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class TodoCsvFilesRepository implements ITodoRepository {
    public static final String DELIMITER = ",";

    public static final String FILE_PATH = System.getenv("APPDATA") + "/todos.csv";


    @Override
    public void addTodo(Todo todo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            String name = todo.getName();
            String dueDateStr = "";

            if (todo.getDueDate() != null) {
                Instant instant = todo.getDueDate().toInstant();
                dueDateStr = instant.toString();
            }

            writer.write(name + DELIMITER + dueDateStr + "\n");
        } catch (IOException e) {
            throw new RuntimeException("Error while writing to CSV file", e);
        }
    }

    @Override
    public List<Todo> getAllTodos() {
        List<Todo> todos = new ArrayList<>();
        try {
            if (!Files.exists(Paths.get(FILE_PATH))) {
                return todos;
            }

            List<String> lines = Files.readAllLines(Paths.get(FILE_PATH));
            for (String line : lines) {
                Todo todo = CSVSerializer.createTodoFromCsvLine(line.split(DELIMITER));
                todos.add(todo);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error reading CSV file", e);
        }
        return todos;
    }

    @Override
    public boolean doesAlreadyNameExists(String name) {
        return getAllTodos().stream()
                .anyMatch(todo -> todo.getName().equalsIgnoreCase(name));
    }
}

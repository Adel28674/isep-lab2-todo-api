package org.isep.cleancode.Presentation;

import org.isep.cleancode.Application.TodoManager;
import org.isep.cleancode.Model.Todo;
import org.isep.cleancode.Util.JsonUtils;
import spark.Request;
import spark.Response;

import java.util.Map;

public class TodoController {

    // this Todo class should be completed to achieve Step 1

    private static final TodoManager todoService = new TodoManager();


    public Object getAllTodos(Request req, Response res) {
        res.type("application/json");

        return todoService.getAllTodos();
    };

    public Object createTodo(Request req, Response res) {
        try{
            Todo newTodo = todoService.addTodo(req.body());
            res.status(201);
            res.type("application/json");
            return JsonUtils.toJson(newTodo);
        }catch (Exception e){
            res.status(400); // Bad Request
            res.type("application/json");
            return JsonUtils.toJson(Map.of("error", e.getMessage()));
        }
    };
}

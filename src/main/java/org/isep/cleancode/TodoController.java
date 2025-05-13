package org.isep.cleancode;

import com.google.gson.Gson;
import org.isep.cleancode.Util.JsonUtils;
import spark.Request;
import spark.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TodoController {

    // this Todo class should be completed to achieve Step 1

    private static final TodoService todoService = new TodoService();


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

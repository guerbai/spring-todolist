package guerbai.springtodolist.controller;

import guerbai.springtodolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/ping")
    public String ping() {
        return "pong!";
    }

    @PostMapping(value="/todo")
    public String addTodoItem() {
        todoService.
        return "1";
    }

    @DeleteMapping(value="/todo/{id}")
    public String deleteTodoItem() {
        return "2";
    }

    @GetMapping(value="/todo/{id}")
    public String getTodoItem() {
        return "3";
    }

    @PutMapping(value="/todo/{id}")
    public String editTodoItem() {
        return "5";
    }

    @GetMapping(value="/todo")
    public String getTodoItemList() {
        return "4";
    }

    @PostMapping(value="/todo/clearup")
    public String removeDoneTodoItemsList() {
        return "6";
    }

}

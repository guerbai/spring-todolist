package guerbai.springtodolist.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class TodoController {

    @GetMapping("/ping")
    public String ping() {
        return "pong!";
    }

    @PostMapping(value="/todo")
    public String addTodoItem() {
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

package guerbai.springtodolist.controller;

import guerbai.springtodolist.domain.Todo;
import guerbai.springtodolist.service.TodoService;
import org.apache.ibatis.ognl.IntHashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/ping")
    public String ping() {
        return "pong!";
    }

    @PostMapping(value="/todo")
    public Map<String, Object> addTodoItem(@RequestBody Todo todo) {
        todoService.insert(todo);
        Map<String, Object> result = new HashMap<>();
        result.put("id", todo.getId());
        return result;
    }

    @DeleteMapping(value="/todo/{id}")
    public String deleteTodoItem(@PathVariable("id") Long id) {
        todoService.delete(id);
        return "";
    }

    @GetMapping(value="/todo/{id}")
    public Todo getTodoItem(@PathVariable("id") Long id) {
        return todoService.getTodoById(id);
    }

    @PutMapping(value="/todo/{id}")
    public Todo editTodoItem(@PathVariable("id") Long id, @RequestBody Todo todo) {
        todoService.update(id, todo);
        return todoService.getTodoById(id);
    }

    @GetMapping(value="/todo")
    public String getTodoItemList() {
        return "4";
    }

    @PostMapping(value="/todo/clearup")
    public String removeDoneTodoItemList() {
        todoService.removeDoneTodoItemList();
        return "clear done!";
    }

}

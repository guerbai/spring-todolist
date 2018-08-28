package guerbai.springtodolist.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import guerbai.springtodolist.domain.Filter;
import guerbai.springtodolist.domain.Todo;
import guerbai.springtodolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
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
        Long id = todoService.insert(todo);
        Map<String, Object> result = new HashMap<>();
        result.put("id", id);
        return result;
    }

    @DeleteMapping(value="/todo/{id}")
    public String deleteTodoItem(@PathVariable("id") Long id) {
        todoService.delete(id);
        return "delete ok!";
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
    public Map<String, Object> getTodoItemList(@RequestParam Map<String, Object> filter) {
        Map<String, Object> result = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        if (filter.get("done") == null) {
            filter.put("done", -1);
        } else if ("true".equals(filter.get("done"))) {
            filter.put("done", 1);
        } else if ("false".equals(filter.get("done"))) {
            filter.put("done", 0);
        }
        Filter filterPojo = mapper.convertValue(filter, Filter.class);
        result.put("todolist", todoService.findTodoByFilter(filterPojo));
        result.put("total_num", todoService.countTodoByFilter(filterPojo));
        return result;
    }

    @PostMapping(value="/todo/clearup")
    public String removeDoneTodoItemList() {
        todoService.removeDoneTodoItemList();
        return "clear done!";
    }

}

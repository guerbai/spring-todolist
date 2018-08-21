package guerbai.springtodolist.service;

import guerbai.springtodolist.domain.Tag;
import guerbai.springtodolist.domain.Todo;

import java.util.List;

public interface TodoService {

    Long insert(Todo todo);

    Todo getTodoById(long id);

    void delete(long id);

    void update(long id, Todo todo);

    void removeDoneTodoItemList();

    List<Todo> findTodoByFilter();

    List<Todo> findTodoByTag(String tagName);

}

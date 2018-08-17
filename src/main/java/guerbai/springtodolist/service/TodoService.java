package guerbai.springtodolist.service;

import guerbai.springtodolist.domain.Todo;

public interface TodoService {

    int insert(Todo todo);

    Todo getTodoById(long id);

    void delete(long id);

    void update(long id, Todo todo);

    void removeDoneTodoItemList();
}

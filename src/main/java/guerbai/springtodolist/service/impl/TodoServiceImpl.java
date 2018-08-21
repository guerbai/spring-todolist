package guerbai.springtodolist.service.impl;

import guerbai.springtodolist.dao.TodoDao;
import guerbai.springtodolist.domain.Todo;
import guerbai.springtodolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoDao todoDao;

    @Override
    public int insert(Todo todo) {
        return todoDao.insert(todo);
    }

    @Override
    public Todo getTodoById(long id) {
        return todoDao.getTodoById(id);
    }

    @Override
    public void delete(long id) {
        todoDao.delete(id);
    }

    @Override
    public void update(long id, Todo todo) {
        todoDao.update(id, todo);
    }

    @Override
    public void removeDoneTodoItemList() {
        todoDao.removeDoneTodoItemList();
    }

    @Override
    public List<Todo> findTodoByFilter() {
        return todoDao.findTodoByFilter();
    }


}

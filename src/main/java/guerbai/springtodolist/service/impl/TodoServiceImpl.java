package guerbai.springtodolist.service.impl;

import guerbai.springtodolist.dao.TagDao;
import guerbai.springtodolist.dao.TodoDao;
import guerbai.springtodolist.domain.Todo;
import guerbai.springtodolist.service.TagService;
import guerbai.springtodolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoDao todoDao;

    @Autowired
    private TagDao tagDao;

    @Autowired
    private TagService tagService;

    @Override
    public Long insert(Todo todo) {
        List<String> tags = todo.getTags();
        List<Long> tagIds = tagService.ensureTags(tags);
        todoDao.insert(todo);
        Long todoId = todo.getId();
        for (Long tagid: tagIds) {
            tagService.link(todo.getId(), tagid);
        }
        return todoId;
    }

    @Override
    public Todo getTodoById(long id) {
        Todo todo = todoDao.getTodoById(id);
        todo.setTags(tagDao.getTagsByTodoId(todo.getId()));
        return todo;
    }

    @Override
    public void delete(long id) {
        tagDao.unlinkByTodoId(id);
        todoDao.delete(id);
    }

//    @Override
//    public void update(long id, Todo todo) {
//        todoDao.update(id, todo);
//    }
//
    @Override
    public void removeDoneTodoItemList() {
        tagDao.clearLinkByDoneTodoItems();
        todoDao.clearDoneItems();
    }

//    @Override
//    public List<Todo> findTodoByFilter() {
//        return todoDao.findTodoByFilter();
//    }
//
//    @Override
//    public List<Todo> findTodoByTag(String tagName) {
//        return todoDao.findTodoByTag(tagName);
//    }


}

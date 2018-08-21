package guerbai.springtodolist.service.impl;

import guerbai.springtodolist.dao.TagDao;
import guerbai.springtodolist.domain.Tag;
import guerbai.springtodolist.domain.Todo;
import guerbai.springtodolist.service.TagService;
import guerbai.springtodolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagDao tagDao;

    @Autowired
    private TodoService todoService;

    @Override
    public int insert(String tag) {
        return tagDao.insert(tag);
    }

    @Override
    public void deleteByTagName(String name) {
        tagDao.deleteByTagName(name);
    }


    @Override
    public Tag findTagByName(String name) {
        return tagDao.findTagByName(name);
    }

    @Override
    public void ensureTags(List<String> tagNameList) {
        for (String tag: tagNameList) {
            if (findTagByName(tag) == null) {
                insert(tag);
            }
        }
    }

    @Override
    public void checkNoUseTags(List<String> tagNameList) {
        for (String tagName: tagNameList) {
            List<Todo> todoList = todoService.findTodoByTag(tagName);
            if (todoList == null) {
                deleteByTagName(tagName);
                tagDao.removeTagLinks(tagName);
            }
        }
    }

    @Override
    public int createTodoTagLink(Long todoId, Long tagId) {
        return tagDao.createTodoTagLink(todoId, tagId);
    }

    @Override
    public List<Long> getTagIdsByNames(List<String> tagNames) {
        return tagDao.getTagIdsByNames(tagNames);
    }

}

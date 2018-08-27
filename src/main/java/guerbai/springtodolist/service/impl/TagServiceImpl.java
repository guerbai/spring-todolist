package guerbai.springtodolist.service.impl;

import guerbai.springtodolist.dao.TagDao;
import guerbai.springtodolist.domain.Tag;
import guerbai.springtodolist.domain.Todo;
import guerbai.springtodolist.service.TagService;
import guerbai.springtodolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagDao tagDao;

//    @Autowired
//    private TodoService todoService;
//
//    @Override
//    public int insert(String tag) {
//        return tagDao.insert(tag);
//    }
//
//    @Override
//    public void deleteByTagName(String name) {
//        tagDao.deleteByTagName(name);
//    }
//
//
//    @Override
//    public Tag findTagByName(String name) {
//        return tagDao.findTagByName(name);
//    }
//
    @Override
    public List<Long> ensureTags(List<String> tagNameList) {
        List<Long> tagIds = new ArrayList<>();
        for (String tag: tagNameList) {
            Tag t = tagDao.findTagByName(tag);
            if (t == null) {
                t = new Tag();
                t.setName(tag);
                tagDao.insert(t);
            }
            tagIds.add(t.getId());
        }
        return tagIds;
    }

//    @Override
//    public void checkNoUseTags(List<Long> tagNameList) {
//        for (Long tagId: tagNameList) {
//            List<Todo> todoList = todoService.findTodoByTag(tagId);
//            if (todoList == null) {
//                deleteByTagName(tagId);
//                tagDao.removeTagLinks(tagId);
//            }
//        }
//    }
//
    @Override
    public int link(Long todoId, Long tagId) {
        return tagDao.link(todoId, tagId);
    }

//    @Override
//    public List<Long> getTagIdsByNames(List<String> tagNames) {
//        return tagDao.getTagIdsByNames(tagNames);
//    }

}

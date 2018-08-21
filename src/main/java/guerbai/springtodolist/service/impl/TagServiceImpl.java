package guerbai.springtodolist.service.impl;

import guerbai.springtodolist.dao.TagDao;
import guerbai.springtodolist.domain.Tag;
import guerbai.springtodolist.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagDao tagDao;

    @Override
    public int insert(Tag tag) {
        return tagDao.insert(tag);
    }

    @Override
    public void delete(long id) {
        tagDao.delete(id);
    }

    @Override
    public Tag findTagByName(String name) {
        return tagDao.findTagByName(name);
    }
}

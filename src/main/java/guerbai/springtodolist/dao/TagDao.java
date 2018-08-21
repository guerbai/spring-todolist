package guerbai.springtodolist.dao;

import guerbai.springtodolist.domain.Tag;

public interface TagDao {

    int insert(Tag tag);

    void delete(long id);

    Tag findTagByName(String name);

}

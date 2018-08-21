package guerbai.springtodolist.service;

import guerbai.springtodolist.domain.Tag;

public interface TagService {

    int insert(Tag tag);

    void delete(long id);

    Tag findTagByName(String name);
}

package guerbai.springtodolist.service;

import guerbai.springtodolist.domain.Tag;

import java.util.List;

public interface TagService {

    int insert(String tag);

    void deleteByTagName(String name);

    Tag findTagByName(String name);

    void ensureTags(List<String> tagNameList);

    void checkNoUseTags(List<String> tagNameList);

    int createTodoTagLink(Long todoId, Long tagId);

    List<Long> getTagIdsByNames(List<String> tagNames);

}

package guerbai.springtodolist.service;

import guerbai.springtodolist.domain.Tag;

import java.util.List;

public interface TagService {

//    int insert(String tag);
//
//    void deleteByTagName(String name);
//
//    Tag findTagByName(String name);
//
    List<Long> ensureTags(List<String> tagNameList);

//    void checkNoUseTags(List<Long> tagIds);
//
    int link(Long todoId, Long tagId);

//    List<Long> getTagIdsByNames(List<String> tagNames);

}

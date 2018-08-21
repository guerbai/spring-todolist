package guerbai.springtodolist.dao;

import guerbai.springtodolist.domain.Tag;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TagDao {

    int insert(String tag);

    Tag findTagByName(String name);

    void deleteByTagName(String name);

    void removeTagLinks(String name);

    int createTodoTagLink(@Param("todoId") Long todoId, @Param("tagId") Long tagId);

    List<Long> getTagIdsByNames(List<String> tagNames);

}

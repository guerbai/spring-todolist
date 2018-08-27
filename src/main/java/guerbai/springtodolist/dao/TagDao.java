package guerbai.springtodolist.dao;

import guerbai.springtodolist.domain.Tag;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TagDao {

    int insert(Tag tag);

    Tag findTagByName(String name);

    int link(@Param("todoId") Long todoId, @Param("tagId") Long tagId);

    List<String> getTagsByTodoId(Long todoId);
//    void deleteByTagName(String name);
//
//    void removeTagLinks(String name);
//

//    List<Long> getTagIdsByNames(List<String> tagNames);
//
//    List<Long> getTagIdsByTodoId(Long id);

}

package guerbai.springtodolist.dao;

import guerbai.springtodolist.domain.Tag;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TagDao {

    int insert(Tag tag);

    Tag findTagByName(String name);

    int link(@Param("todoId") Long todoId, @Param("tagId") Long tagId);

    List<String> getTagsByTodoId(Long todoId);

    void unlinkByTodoId(Long todoId);

    void clearLinkByDoneTodoItems();

}

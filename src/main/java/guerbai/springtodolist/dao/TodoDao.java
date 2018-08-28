package guerbai.springtodolist.dao;

import guerbai.springtodolist.domain.Filter;
import guerbai.springtodolist.domain.Todo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TodoDao {

    int insert(Todo todo) ;

    Todo getTodoById(long id);

    void delete(long id);

    void clearDoneItems();

    void update(@Param("id") long id, @Param("todo") Todo todo);

    List<Todo> findTodoByFilter(@Param("filter") Filter filter);

    Long countTodoByFilter(@Param("filter") Filter filter);

}

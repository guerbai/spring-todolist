package guerbai.springtodolist.dao;

import guerbai.springtodolist.domain.Todo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TodoDao {

    int insert(Todo to) ;

    Todo getTodoById(long id);

    void delete(long id);

    void update(@Param("id") long id, @Param("todo") Todo todo);

    void removeDoneTodoItemList();

    List<Todo> findTodoByFilter();
}

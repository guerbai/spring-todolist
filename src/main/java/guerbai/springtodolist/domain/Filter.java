package guerbai.springtodolist.domain;

import java.util.List;

public class Filter {
    private TodoStatus todoStatus;
    private int num;
    private int page;
    private int offset;
    private String tag;

    public TodoStatus getTodoStatus() {
        return todoStatus;
    }

    public void setTodoStatus(TodoStatus todoStatus) {
        this.todoStatus = todoStatus;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getOffset() {
        return this.num * (this.page - 1);
    }

}

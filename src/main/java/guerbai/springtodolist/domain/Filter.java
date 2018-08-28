package guerbai.springtodolist.domain;

import java.util.List;

public class Filter {
    private int done;
    private int num;
    private int page;
    private int offset;
    private String tag;

    public int isDone() {
        return done;
    }

    public void setDone(int done) {
        this.done = done;
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

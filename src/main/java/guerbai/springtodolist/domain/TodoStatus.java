package guerbai.springtodolist.domain;

public enum TodoStatus {
    DONE("已完成"),
    WAIT("待处理");

    private String value;

    TodoStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}

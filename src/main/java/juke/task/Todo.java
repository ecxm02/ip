package juke.task;

public class Todo extends Task {
    public Todo(String taskName) {
        super(taskName);
    }

    public Todo(String taskName, boolean isDone) {
        super(taskName, isDone);
    }

    @Override
    public String getTaskType() {
        return "T";
    }
}

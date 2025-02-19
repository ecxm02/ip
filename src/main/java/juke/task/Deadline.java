package juke.task;

public class Deadline extends Task {
    private String deadline;

    public Deadline(String task, String deadline) {
        super(task);
        this.deadline = deadline;
    }

    public Deadline(String task, boolean isDone, String deadline) {
        super(task, isDone);
        this.deadline = deadline;
    }

    public String getDeadline() {
        return deadline;
    }

    @Override
    public String getTaskType() {
        return "D";
    }
}

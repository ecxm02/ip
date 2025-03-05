package juke.task;

import java.time.LocalDate;

public class Deadline extends Task {
    private LocalDate deadline;

    public Deadline(String task, LocalDate deadline) {
        super(task);
        this.deadline = deadline;
    }

    public Deadline(String task, boolean isDone, LocalDate deadline) {
        super(task, isDone);
        this.deadline = deadline;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    @Override
    public String getTaskType() {
        return "D";
    }
}

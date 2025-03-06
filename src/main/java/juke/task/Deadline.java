package juke.task;

import java.time.LocalDate;

/**
 * The `Deadline` class represents a task with a specific deadline.
 * It extends the `Task` class and includes a `LocalDate` deadline.
 */
public class Deadline extends Task {
    private LocalDate deadline;

    /**
     * Constructs a new `Deadline` task with the specified task name and deadline.
     *
     * @param task     the name of the task
     * @param deadline the deadline of the task
     */
    public Deadline(String task, LocalDate deadline) {
        super(task);
        this.deadline = deadline;
    }

    /**
     * Constructs a new `Deadline` task with the specified task name, completion status, and deadline.
     *
     * @param task     the name of the task
     * @param isDone   the completion status of the task
     * @param deadline the deadline of the task
     */
    public Deadline(String task, boolean isDone, LocalDate deadline) {
        super(task, isDone);
        this.deadline = deadline;
    }

    /**
     * Returns the deadline of the task.
     *
     * @return the deadline of the task
     */
    public LocalDate getDeadline() {
        return deadline;
    }

    /**
     * Returns the type of the task.
     *
     * @return the type of the task, which is "D" for deadline
     */
    @Override
    public String getTaskType() {
        return "D";
    }
}

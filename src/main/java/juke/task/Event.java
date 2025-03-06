package juke.task;

import java.time.LocalDate;

/**
 * The `Event` class represents a task that occurs within a specific time frame.
 * It extends the `Task` class and includes a start date (`from`) and an end date (`to`).
 */
public class Event extends Task {
    private LocalDate from;
    private LocalDate to;

    /**
     * Constructs a new `Event` task with the specified task name, start date, and end date.
     *
     * @param taskName the name of the task
     * @param from     the start date of the event
     * @param to       the end date of the event
     */
    public Event(String taskName, LocalDate from, LocalDate to){
        super(taskName);
        this.from = from;
        this.to = to;
    }

    /**
     * Constructs a new `Event` task with the specified task name, completion status, start date, and end date.
     *
     * @param taskName the name of the task
     * @param isDone   the completion status of the task
     * @param from     the start date of the event
     * @param to       the end date of the event
     */
    public Event(String taskName, boolean isDone, LocalDate from, LocalDate to){
        super(taskName, isDone);
        this.from = from;
        this.to = to;
    }

    /**
     * Returns the start date of the event.
     *
     * @return the start date of the event
     */
    public LocalDate getFrom() {
        return from;
    }

    /**
     * Returns the end date of the event.
     *
     * @return the end date of the event
     */
    public LocalDate getTo() {
        return to;
    }

    /**
     * Returns the type of the task.
     *
     * @return the type of the task, which is "E" for event
     */
    @Override
    public String getTaskType() {
        return "E";
    }
}

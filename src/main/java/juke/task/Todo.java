package juke.task;

/**
 * Represents a todo task.
 */
public class Todo extends Task {
    /**
     * Constructs a new Todo task with the specified task name.
     *
     * @param taskName the name of the todo task.
     */
    public Todo(String taskName) {
        super(taskName);
    }

    /**
     * Constructs a new Todo task with the specified task name and completion status.
     *
     * @param taskName the name of the todo task.
     * @param isDone   the completion status of the task.
     */
    public Todo(String taskName, boolean isDone) {
        super(taskName, isDone);
    }

    /**
     * Returns the task type identifier.
     *
     * @return "T" indicating a Todo task.
     */
    @Override
    public String getTaskType() {
        return "T";
    }
}

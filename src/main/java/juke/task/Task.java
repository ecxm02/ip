package juke.task;

/**
 * Represents an abstract task with a name and a completion status.
 * Subclasses should implement the abstract method getTaskType to indicate
 * the specific type of task.
 */
public abstract class Task {
    protected String taskName; //actual content of task
    protected boolean isDone; //boolean flag to check if its completed or uncompleted

    /**
     * Constructs a Task with the specified task name.
     *
     * @param taskName the name of the task
     */
    public Task(String taskName) {
        this.taskName = taskName;
        isDone = false;
    }

    /**
     * Constructs a Task with the specified task name and completion status.
     *
     * @param taskName the name of the task
     * @param isDone the completion status of the task
     */
    public Task(String taskName, boolean isDone) {
        this.taskName = taskName;
        this.isDone = isDone;
    }

    /**
     * Returns the name of the task.
     *
     * @return the task name
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * Returns the type of the task.
     * Subclasses must override to specify the task type.
     *
     * @return the type of the task
     */
    public abstract String getTaskType();

    /**
     * Marks this task as completed.
     */
    public void markTask() {
        isDone = true;
    }

    /**
     * Marks this task as not completed.
     */
    public void unmarkTask() {
        isDone = false;
    }

    /**
     * Checks whether the task is completed.
     *
     * @return true if the task is completed, false otherwise
     */
    public boolean isDone() {
        return isDone;
    }
}
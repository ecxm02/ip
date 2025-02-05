public class Task {
    protected String taskName; //actual content of task
    protected boolean isDone; //boolean flag to check if its completed or uncompleted

    public Task(String taskName) {
        this.taskName = taskName;
        isDone = false;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskType() {
        return "X";
    }

    public void markTask() {
        isDone = true;
    }

    public void unmarkTask() {
        isDone = false;
    }

    public boolean isDone() {
        return isDone;
    }
}
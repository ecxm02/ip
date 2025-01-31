public class Task {
    protected String task; //actual content of task
    protected boolean isDone; //boolean flag to check if its completed or uncompleted

    public Task(String description) {
        this.task = null;
        isDone = false;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String text) {
        this.task = text;
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
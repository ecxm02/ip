public class Task {
    protected String task;
    protected boolean isDone;

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
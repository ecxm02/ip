
package juke.task;

import juke.persistence.FileSaver;

import java.util.ArrayList;

public class TaskManager {
    private ArrayList<Task> taskList = new ArrayList<>();

    public TaskManager() {
    }

    public void listTask() { //prints out the tasks and marks them appropriately
        for (int i = 0; i < taskList.size(); i++) {
            Task task = taskList.get(i);
            String isDone;
            String taskType = task.getTaskType();
            String taskName = task.getTaskName();

            if (task.isDone()) {
                isDone = "Completed";
            } else {
                isDone = "Ongoing";
            }

            System.out.print((i + 1) + ". ");

            switch (taskType) {
            case "T":
                System.out.println("[Todo][" + isDone + "]");
                System.out.println("Task Name: " + taskName);
                break;
            case "D":
                Deadline deadlineTask = (Deadline) task;
                System.out.println("[Todo][" + isDone + "]");
                System.out.println("Task Name: " + taskName);
                System.out.println("Deadline: " + deadlineTask.getDeadline());
                break;
            case "E":
                Event eventTask = (Event) task;
                System.out.println("[Todo][" + isDone + "]");
                System.out.println("Task Name: " + taskName);
                System.out.println("From: " + eventTask.getFrom());
                System.out.println("To: " + eventTask.getTo());
                break;
            }
            System.out.println("");
        }
    }

    public void addTodo(String taskName) { //adds tasks into the array
        Task newTask = new Todo(taskName);
        taskList.add(newTask);
        System.out.println("Okay! I've added a new todo");
        System.out.println(taskList.size() + ". " + taskName);
        FileSaver.writeToFile(newTask);
    }

    public void addDeadline(String taskName, String deadline) { //adds tasks into the array
        Task newTask = new Deadline(taskName, deadline);
        taskList.add(newTask);
        System.out.println("Okay! I've added a new deadline");
        System.out.println(taskList.size() + ". " + taskName);
        System.out.println("Deadline: " + deadline);
        FileSaver.writeToFile(newTask);
    }

    public void addEvent(String taskName, String from, String to) { //adds tasks into the array
        Task newTask = new Event(taskName, from, to);
        taskList.add(newTask);
        System.out.println("Okay! I've added a new event");
        System.out.println(taskList.size() + ". " + taskName);
        System.out.println("From: " + from);
        System.out.println("To: " + to);
        FileSaver.writeToFile(newTask);
    }

    public void markTask(int taskIndex) { //marks a task as completed
        taskList.get(taskIndex).markTask();
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(taskIndex + 1 + ". " + taskList.get(taskIndex).getTaskName() + "[Completed]");
    }

    public void unmarkTask(int taskIndex) { //marks a task as uncompleted
        taskList.get(taskIndex).unmarkTask();
        System.out.println("Okay! I've marked this task as uncompleted:");
        System.out.println(taskIndex + 1 + ". " + taskList.get(taskIndex).getTaskName() + "[Ongoing]");
    }

    public void clearTaskList() {
        taskList.clear();
        FileSaver.clearSaveFile();
        System.out.println("Okay! I've cleared the task list");
    }

    public ArrayList<Task> getTaskList() {
        return taskList;

    public void deleteTask(int taskIndex) {
        String taskName = taskList.get(taskIndex).getTaskName();
        taskList.remove(taskIndex);
        System.out.println("Okay! I've deleted this task");
        System.out.println(taskIndex + 1 + ". " + taskName);
    }
}

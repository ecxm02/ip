package juke.task;

import java.util.ArrayList;

public class TaskManager {
    private ArrayList<Task> taskList = new ArrayList<>();

    public TaskManager() {
    }

    public void listTask() { //prints out the tasks and marks them appropriately
        for (int i = 0; i < taskList.size(); i++) {
            System.out.print((i + 1));

            if (taskList.get(i).isDone()) {
                System.out.println(".[" + taskList.get(i).getTaskType() + "][X] " + taskList.get(i).getTaskName());
            } else {
                System.out.println(".[" + taskList.get(i).getTaskType() + "][ ] " + taskList.get(i).getTaskName());
            }
        }
    }

    public void addTodo(String taskName) { //adds tasks into the array
        taskList.add(new Todo(taskName));
        System.out.println("Okay! I've added a new todo");
        System.out.println(taskList.size() + ". " + taskName);
    }

    public void addDeadline(String taskName, String deadline) { //adds tasks into the array
        taskList.add(new Deadline(taskName, deadline));
        System.out.println("Okay! I've added a new deadline");
        System.out.println(taskList.size() + ". " + taskName);
        System.out.println("Deadline: " + deadline);
    }

    public void addEvent(String taskName, String from, String to) { //adds tasks into the array
        taskList.add(new Event(taskName, from, to));
        System.out.println("Okay! I've added a new event");
        System.out.println(taskList.size() + ". " + taskName);
        System.out.println("From: " + from);
        System.out.println("To: " + to);
    }

    public void markTask(int taskIndex) { //marks a task as completed
        taskList.get(taskIndex).markTask();
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("[X] " + taskList.get(taskIndex).getTaskName());
    }

    public void unmarkTask(int taskIndex) { //marks a task as uncompleted
        taskList.get(taskIndex).unmarkTask();
        System.out.println("Okay! I've marked this task as uncompleted:");
        System.out.println("[ ] " + taskList.get(taskIndex).getTaskName());
    }
}

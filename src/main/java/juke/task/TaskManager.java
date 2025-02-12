package juke.task;

import juke.main.Constants;

public class TaskManager {
    private Task[] taskList = new Task[Constants.LIST_SIZE];
    private int currentListPosition = 0; //keep track of where to add new tasks

    public TaskManager() {
    }

    public void listTask() { //prints out the tasks and marks them appropriately
        for (int i = 0; i < currentListPosition; i++) {
            System.out.print((i + 1));

            if (taskList[i].isDone()) {
                System.out.println(".[" + taskList[i].getTaskType() + "][X] " + taskList[i].getTaskName());
            } else {
                System.out.println(".[" + taskList[i].getTaskType() + "][ ] " + taskList[i].getTaskName());
            }
        }
    }

    public void addTodo(String taskName) { //adds tasks into the array
        taskList[currentListPosition] = new Todo(taskName);
        currentListPosition += 1;
        System.out.println("Okay! I've added a new todo");
        System.out.println((currentListPosition) + ". " + taskName);
    }

    public void addDeadline(String taskName, String deadline) { //adds tasks into the array
        taskList[currentListPosition] = new Deadline(taskName, deadline);
        currentListPosition += 1;
        System.out.println("Okay! I've added a new deadline");
        System.out.println((currentListPosition) + ". " + taskName);
        System.out.println("Deadline: " + deadline);
    }

    public void addEvent(String taskName, String from, String to) { //adds tasks into the array
        taskList[currentListPosition] = new Event(taskName, from, to);
        currentListPosition += 1;
        System.out.println("Okay! I've added a new event");
        System.out.println((currentListPosition) + ". " + taskName);
        System.out.println("From: " + from);
        System.out.println("To: " + to);
    }

    public void markTask(int taskIndex) { //marks a task as completed
        taskList[taskIndex].markTask();
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("[X] " + taskList[taskIndex].getTaskName());
    }

    public void unmarkTask(int taskIndex) { //marks a task as uncompleted
        taskList[taskIndex].unmarkTask();
        System.out.println("Okay! I've marked this task as uncompleted:");
        System.out.println("[ ] " + taskList[taskIndex].getTaskName());
    }
}

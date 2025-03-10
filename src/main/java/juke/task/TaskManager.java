
package juke.task;

import juke.storage.FileSaver;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.time.LocalDate;

/**
 * Manages a list of tasks, providing operations to list, add, modify, and delete tasks.
 */
public class TaskManager {
    private static ArrayList<Task> taskList = new ArrayList<>();

    private TaskManager() {
    }

    /**
     * Lists all tasks in the task list with their details.
     */
    public static void listTask() {
        for (int i = 0; i < taskList.size(); i++) {
            Task task = taskList.get(i);
            String isDone;
            String taskType = task.getTaskType();
            String taskName = task.getTaskName();

            if (task.isDone()) {
                isDone = "Completed";
            } else {
                isDone = "Incomplete";
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
                System.out.println("Deadline: " + deadlineTask.getDeadline().format(DateTimeFormatter.ofPattern("dd-MMMM-yyyy")));
                break;
            case "E":
                Event eventTask = (Event) task;
                System.out.println("[Todo][" + isDone + "]");
                System.out.println("Task Name: " + taskName);
                System.out.println("From: " + eventTask.getFrom().format(DateTimeFormatter.ofPattern("dd-MMMM-yyyy")));
                System.out.println("To: " + eventTask.getTo().format(DateTimeFormatter.ofPattern("dd-MMMM-yyyy")));
                break;
            default:
                System.out.println("Error in case type, check TaskManager class");
            }
            System.out.println("");
        }
    }

    /**
     * Displays details for a single task.
     *
     * @param task the task to display.
     */
    private static void listOneTask(Task task) {
        String isDone;
        String taskType = task.getTaskType();
        String taskName = task.getTaskName();
        int taskIndex = taskList.indexOf(task);

        if (task.isDone()) {
            isDone = "Completed";
        } else {
            isDone = "Incomplete";
        }

        System.out.print((taskIndex + 1) + ". ");

        switch (taskType) {
        case "T":
            System.out.println("[Todo][" + isDone + "]");
            System.out.println("Task Name: " + taskName);
            break;
        case "D":
            Deadline deadlineTask = (Deadline) task;
            System.out.println("[Todo][" + isDone + "]");
            System.out.println("Task Name: " + taskName);
            System.out.println("Deadline: " + deadlineTask.getDeadline().format(DateTimeFormatter.ofPattern("dd-MMMM-yyyy")));
            break;
        case "E":
            Event eventTask = (Event) task;
            System.out.println("[Todo][" + isDone + "]");
            System.out.println("Task Name: " + taskName);
            System.out.println("From: " + eventTask.getFrom().format(DateTimeFormatter.ofPattern("dd-MMMM-yyyy")));
            System.out.println("To: " + eventTask.getTo().format(DateTimeFormatter.ofPattern("dd-MMMM-yyyy")));
            break;
        default:
            System.out.println("Error in case type, check TaskManager class");
        }
        System.out.println("");
    }

    /**
     * Creates a new todo task and adds it to the task list.
     *
     * @param taskName the name of the todo task.
     */
    public static void addTodo(String taskName) {
        Task newTask = new Todo(taskName);
        taskList.add(newTask);
        System.out.println("Okay! I've added a new todo");
        System.out.println(taskList.size() + ". " + taskName);
        FileSaver.writeToFile(newTask);
    }

    /**
     * Creates a new deadline task and adds it to the task list.
     *
     * @param taskName the name of the deadline task.
     * @param deadline the due date of the task.
     */
    public static void addDeadline(String taskName, LocalDate deadline) {
        Task newTask = new Deadline(taskName, deadline);
        taskList.add(newTask);
        System.out.println("Okay! I've added a new deadline");
        System.out.println(taskList.size() + ". " + taskName);
        System.out.println("Deadline: " + deadline.format(DateTimeFormatter.ofPattern("dd-MMMM-yyyy")));
        FileSaver.writeToFile(newTask);
    }

    /**
     * Creates a new event task and adds it to the task list.
     *
     * @param taskName the name of the event.
     * @param from the start date of the event.
     * @param to the end date of the event.
     */
    public static void addEvent(String taskName, LocalDate from, LocalDate to) {
        Task newTask = new Event(taskName, from, to);
        taskList.add(newTask);
        System.out.println("Okay! I've added a new event");
        System.out.println(taskList.size() + ". " + taskName);
        System.out.println("From: " + from.format(DateTimeFormatter.ofPattern("dd-MMMM-yyyy")));
        System.out.println("To: " + to.format(DateTimeFormatter.ofPattern("dd-MMMM-yyyy")));
        FileSaver.writeToFile(newTask);
    }

    /**
     * Marks the specified task as completed.
     *
     * @param taskIndex the index of the task to mark.
     */
    public static void markTask(int taskIndex) {
        taskList.get(taskIndex).markTask();
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(taskIndex + 1 + ". Task Name: " + taskList.get(taskIndex).getTaskName());
        System.out.println("Status: [Completed]");
    }

    /**
     * Marks the specified task as incomplete.
     *
     * @param taskIndex the index of the task to unmark.
     */
    public static void unmarkTask(int taskIndex) {
        taskList.get(taskIndex).unmarkTask();
        System.out.println("Okay! I've marked this task as incomplete:");
        System.out.println(taskIndex + 1 + ". Task Name: " + taskList.get(taskIndex).getTaskName());
        System.out.println("Status: [Incomplete]");
    }

    /**
     * Clears all tasks from the task list and the associated save file.
     */
    public static void clearTaskList() {
        taskList.clear();
        FileSaver.clearSaveFile();
        System.out.println("Okay! I've cleared the task list");
    }

    public static ArrayList<Task> getTaskList() {
        return taskList;
    }

    /**
     * Deletes the specified task from the task list.
     *
     * @param taskIndex the index of the task to delete.
     */
    public static void deleteTask(int taskIndex) {
        String taskName = taskList.get(taskIndex).getTaskName();
        taskList.remove(taskIndex);
        System.out.println("Okay! I've deleted this task");
        System.out.println(taskIndex + 1 + ". " + taskName);
    }

    /**
     * Searches and displays tasks that contain the given keyword.
     *
     * @param keyword the keyword to search for.
     */
    public static void findTask(String keyword) {
        int found = 0;
        for (Task task : taskList) {
            if (task.getTaskName().contains(keyword)) {
                listOneTask(task);
                found += 1;
            }
        }
        if (found == 0) {
            System.out.println("No tasks found with the keyword: " + keyword);
        }
    }

    public static int getSize() {
        return taskList.size();
    }
}

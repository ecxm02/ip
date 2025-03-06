package juke.storage;

import juke.main.Constants;
import juke.task.Deadline;
import juke.task.Event;
import juke.task.Task;
import juke.task.Todo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * The `FileLoader` class is responsible for loading tasks from a save file.
 * It reads the file line by line, parses the task information, and adds the tasks to the provided task list.
 */
public class FileLoader {
    private static String taskType;
    private static String taskName;
    private static LocalDate deadline;
    private static LocalDate from;
    private static LocalDate to;
    private static boolean isDone;

    private FileLoader() {
    }

    /**
     * Loads tasks from the save file and adds them to the provided task list.
     * If the save file is not found, it starts with a new task list.
     *
     * @param taskList the list to which the loaded tasks will be added
     */
    public static void loadFile(ArrayList<Task> taskList) {
        try (BufferedReader reader = new BufferedReader(new FileReader(Constants.SAVE_FILE_NAME))) {
            System.out.println("Save file found, loading save file");
            String line;

            while ((line = reader.readLine()) != null) { //Reads one line at a time
                String[] words = line.split("\\|");
                taskType = words[0];
                isDone = Boolean.parseBoolean(words[1]);

                switch (taskType) {
                case "T":
                    taskName = words[2];
                    taskList.add(new Todo(taskName, isDone));
                    break;
                case "D":
                    taskName = words[2];
                    String deadlineString = words[3];
                    deadline = LocalDate.parse(deadlineString);
                    taskList.add(new Deadline(taskName, isDone, deadline));
                    break;
                case "E":
                    taskName = words[2];
                    String fromString = words[3];
                    String toString = words[4];
                    from = LocalDate.parse(fromString);
                    to = LocalDate.parse(toString);
                    taskList.add(new Event(taskName, isDone, from, to));
                default:
                    System.out.println("Error in case type, check FileLoader class");
                }
            }

        } catch (IOException e) {
            System.out.println("No save file found! Will start on a new task list");
        }
    }
}

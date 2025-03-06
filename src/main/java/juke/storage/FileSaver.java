package juke.storage;

import juke.main.Constants;
import juke.task.Task;
import juke.task.Deadline;
import juke.task.Event;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

/**
 * The `FileSaver` class is responsible for saving tasks to a file.
 * It provides methods to write tasks to the file, clear the save file, and ensure the save directory exists.
 */
public class FileSaver {
    private FileSaver() {
    }

    /**
     * Writes a task to the save file.
     * The task is appended to the file in a specific format based on its type.
     *
     * @param task the task to be written to the file
     */
    public static void writeToFile(Task task) {
        ensureDirectoryExists();

        try (FileWriter writer = new FileWriter((Constants.SAVE_FILE_NAME), true)) {
            String taskType = task.getTaskType();
            switch (taskType) {
            case "T":
                writer.write("T" + "|" + task.isDone() + "|" + task.getTaskName() + System.lineSeparator());
                break;
            case "D":
                Deadline deadlineTask = (Deadline) task;
                writer.write("D" + "|" + task.isDone() + "|" + deadlineTask.getTaskName() + "|"
                        + deadlineTask.getDeadline() + System.lineSeparator());
                break;
            case "E":
                Event eventTask = (Event) task;
                writer.write("E" + "|" + task.isDone() + "|" + eventTask.getTaskName() + "|"
                        + eventTask.getFrom() + "|" + eventTask.getTo() + System.lineSeparator());
                break;
            }

        } catch (IOException e) {
            System.out.println("Error writing to file.");
            e.printStackTrace();
        }
    }

    /**
     * Clears the save file by deleting it if it exists.
     */
    public static void clearSaveFile() {
        File file = new File(Constants.SAVE_FILE_NAME);

        if (file.exists()) {
            file.delete();
        }
    }

    /**
     * Ensures that the save directory exists.
     * If the directory does not exist, it creates the directory and any necessary parent directories.
     */
    public static void ensureDirectoryExists() {
        File directory = new File(Constants.SAVE_FILE_PATH);

        if (!directory.exists()) {
            directory.mkdirs(); // Creates the directory and any necessary parents
        }
    }

}

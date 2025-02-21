package juke.persistence;

import juke.main.Constants;
import juke.task.Task;
import juke.task.Deadline;
import juke.task.Event;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;


public class FileSaver {
    private FileSaver() {
    }

    public static void writeToFile(Task task) {

        try (FileWriter writer = new FileWriter((Constants.SAVE_FILE_PATH), true)) {
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

    public static void clearSaveFile() {
        File file = new File(Constants.SAVE_FILE_PATH);

        if (file.exists()) {
            file.delete();
        }
    }
}

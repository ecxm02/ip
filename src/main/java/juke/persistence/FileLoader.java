package juke.persistence;

import juke.main.Constants;
import juke.task.Deadline;
import juke.task.Event;
import juke.task.Task;
import juke.task.Todo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileLoader {
    private static String taskType;
    private static String taskName;
    private static String deadline;
    private static String from;
    private static String to;
    private static boolean isDone;

    private FileLoader() {
    }

    public static void readFromFile(ArrayList<Task> taskList) {
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
                    deadline = words[3];
                    taskList.add(new Deadline(taskName, isDone, deadline));
                    break;
                case "E":
                    taskName = words[2];
                    from = words[3];
                    to = words[4];
                    taskList.add(new Event(taskName, isDone, from, to));
                }
            }

        } catch (IOException e) {
            System.out.println("No save file found! Will start on a new task list");
        }
    }
}

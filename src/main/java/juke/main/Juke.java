package juke.main;

import juke.exception.ExceptionHandler;
import juke.input.Ui;
import juke.storage.FileLoader;
import juke.task.TaskManager;

public class Juke {
    private static boolean isRunning = true; //a master flag so that main knows when to end the program

    public static boolean isRunning() {
        return isRunning;
    }

    public static void endProgram() {
        //sets the isCompleted flag to true so that the loop ends, also prints end message
        isRunning = false;
    }

    public static void main(String[] args) {
        ExceptionHandler.activate();
        FileLoader.loadFile(TaskManager.getTaskList());
        Ui.introMessage();

        while (isRunning) {
            Ui.readInput();
        }

        Ui.endProgramMessage();
        Ui.closeInput();
    }
}
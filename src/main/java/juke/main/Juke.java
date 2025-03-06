package juke.main;

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
        FileLoader.loadFile(TaskManager.getTaskList());
        Ui.introMessage();

        while (Juke.isRunning()) {
            try {
                Ui.readInput();
            } catch (Exception e) {
                System.out.println(Constants.LINE_BREAK);
            }
        }

        Ui.endProgramMessage();
        Ui.closeInput();
    }
}
package juke.main;

import juke.input.UI;
import juke.storage.FileLoader;
import juke.task.TaskManager;

public class Juke {
    private static boolean isCompleted = false;//a master flag so that main knows when to end the program

    public static void endProgram() {
        //sets the isCompleted flag to true so that the loop ends, also prints end message
        isCompleted = true;
    }

    public static void main(String[] args) {
        FileLoader.loadFile(TaskManager.getTaskList());
        UI.introMessage();

        while (!isCompleted) {
            UI.readInput();
        }

        UI.endProgramMessage();
        UI.closeInput();
    }
}
package juke.main;

import juke.input.Ui;
import juke.storage.FileLoader;
import juke.task.TaskManager;

/**
 * The `Juke` class serves as the main entry point for the application.
 * It manages the program's lifecycle, including initialization, running the main loop, and termination.
 */
public class Juke {
    private static boolean isRunning = true; //a master flag so that main knows when to end the program

    public static boolean isRunning() {
        return isRunning;
    }

    /**
     * Ends the program by setting the `isRunning` flag to false.
     * This causes the main loop to terminate.
     */
    public static void endProgram() {
        isRunning = false;
    }

    /**
     * The main method initializes the application, displays the intro message,
     * and enters the main loop to process user input until the program is terminated.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        FileLoader.loadFile(TaskManager.getTaskList());
        Ui.introMessage();

        while (Juke.isRunning()) {
            try {
                Ui.readInput();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println(Constants.LINE_BREAK);
            }
        }

        Ui.endProgramMessage();
        Ui.closeInput();
    }
}
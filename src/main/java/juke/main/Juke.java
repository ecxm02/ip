package juke.main;

import juke.input.InputHandler;
import juke.persistence.FileLoader;
import juke.task.TaskManager;

import java.util.Scanner;

public class Juke {
    private static boolean isCompleted = false;//a master flag so that main knows when to end the program
    private static TaskManager taskManager = new TaskManager();

    public static void endProgram() {
        //sets the isCompleted flag to true so that the loop ends, also prints end message
        isCompleted = true;
        System.out.println("Bye! See you again!");
    }

    public static void main(String[] args) {
        FileLoader.readFromFile(taskManager.getTaskList());
        System.out.println(Constants.INTRO_MESSAGE);
        Scanner input = new Scanner(System.in);
        String text;

        while (!isCompleted) {
            text = input.nextLine();
            InputHandler.readText(taskManager,text);
        }

        input.close();
    }
}
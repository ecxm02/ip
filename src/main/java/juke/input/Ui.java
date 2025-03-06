package juke.input;

import juke.main.Constants;

import java.util.Scanner;

/**
 * The `Ui` class handles user interaction, including displaying messages and reading input.
 */
public class Ui {
    private Ui() {
    }

    private static Scanner input = new Scanner(System.in);
    private static String text;

    /**
     * Displays the introductory message and help message to the user.
     */
    public static void introMessage() {
        System.out.println(Constants.INTRO_MESSAGE);
        System.out.print(Constants.HELP_MESSAGE);
        System.out.println(Constants.LINE_BREAK + System.lineSeparator());
    }

    /**
     * Displays the end program message to the user.
     */
    public static void endProgramMessage() {
        System.out.println(Constants.END_MESSAGE);
    }

    /**
     * Reads input from the user and passes it to the InputHandler.
     */
    public static void readInput() {
        text = input.nextLine();
        InputHandler.readText(text);
    }

    /**
     * Closes the input scanner.
     */
    public static void closeInput() {
        input.close();
    }
}

package juke.input;

import juke.main.Constants;

import java.util.Scanner;

public class UI {
    private UI() {
    }

    private static Scanner input = new Scanner(System.in);
    private static String text;

    public static void introMessage() {
        System.out.println(Constants.INTRO_MESSAGE);
    }

    public static void endProgramMessage() {
        System.out.println(Constants.END_MESSAGE);
    }

    public static void readInput() {
        text = input.nextLine();
        InputHandler.readText(text);
    }

    public static void closeInput() {
        input.close();
    }
}

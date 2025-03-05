package juke.exception;

import juke.input.Ui;
import juke.main.Juke;
import juke.main.Constants;

public class ExceptionHandler {
    private ExceptionHandler() {
    }

    public static void activate() {
        Thread.setDefaultUncaughtExceptionHandler((thread, throwable) -> {
            System.out.println(Constants.LINE_BREAK);

            while (Juke.isRunning()) {
                try {
                    Ui.readInput();
                } catch (Exception e) {
                    System.out.println(Constants.LINE_BREAK);
                }
            }

            Ui.endProgramMessage();
            Ui.closeInput();
        });
    }
}
package juke.input;

import juke.exception.*;
import juke.main.Constants;

import java.time.LocalDate;

public class Parser {
    private static String textInput;
    private static String inputCommand = "invalid";
    private static String taskName;
    private static String taskNumber;
    private static int taskIndex = -1;
    private static int spaceIndex = -1;
    private static int slashIndex = -1;
    private static int slashIndex2 = -1;
    private static LocalDate deadline;
    private static LocalDate from;
    private static LocalDate to;

    private Parser() {
    }

    public static void cleanText(String text) {
        resetVariables();
        textInput = text;

        spaceIndex = textInput.indexOf(" ");
        slashIndex = textInput.indexOf("/", spaceIndex + Constants.EMPTY_PAD);
        slashIndex2 = textInput.indexOf("/", slashIndex + Constants.EMPTY_PAD);

        if (textInput.startsWith("mark") || textInput.startsWith("unmark")) {
            cleanUpMark();
        } else if (textInput.startsWith("todo")) {
            cleanUpTodo();
        } else if (textInput.startsWith("deadline")) {
            cleanUpDeadline();
        } else if (textInput.startsWith("event")) {
            cleanUpEvent();
        } else if (textInput.startsWith("delete")) {
            cleanUpDelete();
        } else if (textInput.startsWith("list")) {
            inputCommand = "list";
        } else if (textInput.startsWith("bye")) {
            inputCommand = "bye";
        } else if (textInput.startsWith("clear")) {
            inputCommand = "clear";
        } else if (textInput.startsWith("help")) {
            inputCommand = "help";
        }
    }

    private static void cleanUpMark() throws MarkParserException {
        String[] words = textInput.split(" ");
        if (words.length < 2) {
            throw new MarkParserException();
        }
        taskNumber = words[1];
        taskIndex = Integer.parseInt(taskNumber) - 1;
        inputCommand = words[0];
    }

    private static void cleanUpTodo() throws TodoParserException {
        if (spaceIndex == -1) {
            throw new TodoParserException();
        }
        inputCommand = textInput.substring(0, spaceIndex);
        taskName = textInput.substring(spaceIndex + Constants.EMPTY_PAD);
    }

    private static void cleanUpDeadline() throws DeadlineParserException {
        if (spaceIndex == -1 || slashIndex == -1) {
            throw new DeadlineParserException();
        }
        inputCommand = textInput.substring(0, spaceIndex);
        taskName = textInput.substring(spaceIndex + Constants.EMPTY_PAD, slashIndex - Constants.EMPTY_PAD);
        String deadlineString = textInput.substring(slashIndex + Constants.BY_PAD);
        try {
            deadline = LocalDate.parse(deadlineString);
        } catch (Exception e) {
            throw new DateParserException();
        }
    }

    private static void cleanUpEvent() throws EventParserException {
        if (spaceIndex == -1 || slashIndex == -1 || slashIndex2 == -1) {
            throw new EventParserException();
        }
        inputCommand = textInput.substring(0, spaceIndex);
        taskName = textInput.substring(spaceIndex + Constants.EMPTY_PAD, slashIndex - Constants.EMPTY_PAD);
        String fromString = textInput.substring(slashIndex + Constants.FROM_PAD, slashIndex2 - Constants.EMPTY_PAD);
        String toString = textInput.substring(slashIndex2 + Constants.TO_PAD);
        try {
            from = LocalDate.parse(fromString);
            to = LocalDate.parse(toString);
        } catch (Exception e) {
            throw new DateParserException();
        }
    }

    private static void cleanUpDelete() throws DeleteParserException {
        String[] words = textInput.split(" ");
        if (words.length < 2) {
            throw new DeleteParserException();
        }
        taskNumber = words[1];
        taskIndex = Integer.parseInt(taskNumber) - 1;
        inputCommand = words[0];
    }

    private static void resetVariables() {
        inputCommand = "invalid";
        taskName = null;
        taskNumber = null;
        taskIndex = -1;
        spaceIndex = -1;
        slashIndex = -1;
        slashIndex2 = -1;
        deadline = null;
        from = null;
        to = null;
    }

    public static String getInputCommand() {
        return inputCommand;
    }

    public static int getTaskIndex() {
        return taskIndex;
    }

    public static String getTaskName() {
        return taskName;
    }

    public static LocalDate getDeadline() {
        return deadline;
    }

    public static LocalDate getFrom() {
        return from;
    }

    public static LocalDate getTo() {
        return to;
    }
}

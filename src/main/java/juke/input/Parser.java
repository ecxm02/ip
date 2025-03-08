package juke.input;

import juke.exception.*;
import juke.main.Constants;
import juke.task.TaskManager;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The `Parser` class is responsible for parsing and validating user input commands.
 * It cleans the input text, determines the command, and extracts the necessary parameters.
 * This class also handles exceptions related to incorrect command formats.
 */
public class Parser {
    private static String textInput;
    private static String inputCommand = "invalid";
    private static String taskName;
    private static String taskNumber;
    private static int taskIndex;
    private static LocalDate deadline;
    private static LocalDate from;
    private static LocalDate to;

    private Parser() {
    }

    /**
     * Cleans and parses the input text to determine the command and its parameters.
     *
     * @param text the input text to be parsed
     */
    public static void cleanText(String text) {
        resetVariables();
        textInput = text;

        if (textInput.startsWith("mark")) {
            cleanUpMark();
        } else if (textInput.startsWith("unmark")) {
            cleanUpUnmark();
        } else if (textInput.startsWith("todo")) {
            cleanUpTodo();
        } else if (textInput.startsWith("deadline")) {
            cleanUpDeadline();
        } else if (textInput.startsWith("event")) {
            cleanUpEvent();
        } else if (textInput.startsWith("delete")) {
            cleanUpDelete();
        } else if (textInput.startsWith("find")) {
            cleanUpFind();
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

    /**
     * Parses and validates the 'mark' command.
     *
     * @throws MarkParserException if the input does not match the expected format
     */
    private static void cleanUpMark() throws MarkParserException {
        Pattern pattern = Pattern.compile(Constants.MARK_REGEX);
        Matcher matcher = pattern.matcher(textInput);
        if (matcher.matches()) {
            taskNumber = matcher.group(1);
            taskIndex = Integer.parseInt(taskNumber) - 1;
            if (TaskManager.getSize() <= taskIndex) {
                throw new TaskIndexOutOfBounds();
            }
            inputCommand = "mark";
        } else {
            throw new MarkParserException();
        }
    }

    /**
     * Parses and validates the 'unmark' command.
     *
     * @throws UnmarkParserException if the input does not match the expected format
     */
    private static void cleanUpUnmark() throws UnmarkParserException {
        Pattern pattern = Pattern.compile(Constants.UNMARK_REGEX);
        Matcher matcher = pattern.matcher(textInput);
        if (matcher.matches()) {
            taskNumber = matcher.group(1);
            taskIndex = Integer.parseInt(taskNumber) - 1;
            if (TaskManager.getSize() <= taskIndex) {
                throw new TaskIndexOutOfBounds();
            }
            inputCommand = "unmark";
        } else {
            throw new UnmarkParserException();
        }
    }


    /**
     * Parses and validates the 'todo' command.
     *
     * @throws TodoParserException if the input does not match the expected format
     */
    private static void cleanUpTodo() throws TodoParserException {
        Pattern pattern = Pattern.compile(Constants.TODO_REGEX);
        Matcher matcher = pattern.matcher(textInput);
        if (matcher.matches()) {
            taskName = matcher.group(1);
            inputCommand = "todo";
        } else {
            throw new TodoParserException();
        }
    }

    /**
     * Parses and validates the 'deadline' command.
     *
     * @throws DeadlineParserException if the input does not match the expected format
     */
    private static void cleanUpDeadline() throws DeadlineParserException {
        Pattern pattern = Pattern.compile(Constants.DEADLINE_REGEX);
        Matcher matcher = pattern.matcher(textInput);
        if (matcher.matches()) {
            taskName = matcher.group(1);
            String deadlineString = matcher.group(2);
            try {
                deadline = LocalDate.parse(deadlineString);
                inputCommand = "deadline";
            } catch (Exception e) {
                throw new DateParserException();
            }
        } else {
            throw new DeadlineParserException();
        }
    }

    /**
     * Parses and validates the 'event' command.
     *
     * @throws EventParserException if the input does not match the expected format
     */
    private static void cleanUpEvent() throws EventParserException {
        Pattern pattern = Pattern.compile(Constants.EVENT_REGEX);
        Matcher matcher = pattern.matcher(textInput);
        if (matcher.matches()) {
            taskName = matcher.group(1);
            String fromString = matcher.group(2);
            String toString = matcher.group(3);
            try {
                from = LocalDate.parse(fromString);
                to = LocalDate.parse(toString);
                inputCommand = "event";
            } catch (Exception e) {
                throw new DateParserException();
            }
        } else {
            throw new EventParserException();
        }
    }

    /**
     * Parses and validates the 'delete' command.
     *
     * @throws DeleteParserException if the input does not match the expected format
     */
    private static void cleanUpDelete() throws DeleteParserException {
        Pattern pattern = Pattern.compile(Constants.DELETE_REGEX);
        Matcher matcher = pattern.matcher(textInput);
        if (matcher.matches()) {
            taskNumber = matcher.group(1);
            taskIndex = Integer.parseInt(taskNumber) - 1;
            if (TaskManager.getSize() <= taskIndex) {
                throw new TaskIndexOutOfBounds();
            }
            inputCommand = "delete";
        } else {
            throw new DeleteParserException();
        }
    }

    /**
     * Parses and validates the 'find' command.
     *
     * @throws FindParserException if the input does not match the expected format
     */
    private static void cleanUpFind() throws FindParserException {
        Pattern pattern = Pattern.compile(Constants.FIND_REGEX);
        Matcher matcher = pattern.matcher(textInput);
        if (matcher.matches()) {
            taskName = matcher.group(1);
            inputCommand = "find";
        } else {
            throw new FindParserException();
        }
    }

    /**
     * Resets all parser variables to their default values.
     */
    private static void resetVariables() {
        inputCommand = "invalid";
        taskName = null;
        taskNumber = null;
        taskIndex = -1;
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

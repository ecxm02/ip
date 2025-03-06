package juke.input;

import juke.exception.*;
import juke.main.Constants;
import juke.task.TaskManager;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    private static void cleanUpDelete() throws DeleteParserException {
        Pattern pattern = Pattern.compile(Constants.DELETE_REGEX);
        Matcher matcher = pattern.matcher(textInput);
        if (matcher.matches()) {
            taskName = matcher.group(1);
            taskNumber = matcher.group(2);
            taskIndex = Integer.parseInt(taskNumber) - 1;
            if (TaskManager.getSize() <= taskIndex) {
                throw new TaskIndexOutOfBounds();
            }
            inputCommand = "delete";
        } else {
            throw new DeleteParserException();
        }
    }

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

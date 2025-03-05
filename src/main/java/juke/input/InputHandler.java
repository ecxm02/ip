package juke.input;

import juke.task.TaskManager;
import juke.main.Juke;
import juke.main.Constants;

public class InputHandler {
    private static String textInput;

    private InputHandler() {
    }

    public static void readText(String textInput) {
        Parser.cleanText(textInput);
        respondToText(Parser.getInputCommand(), Parser.getTaskName(), Parser.getTaskIndex(),
                Parser.getDeadline(), Parser.getFrom(), Parser.getTo());
    }

    //uses a switch to execute appropriate methods for the input
    public static void respondToText(String inputCommand, String taskName, int taskIndex,
                                     String deadline, String from, String to) {

        switch (inputCommand) {
        case "bye":
            Juke.endProgram();
            break;
        case "list":
            TaskManager.listTask();
            break;
        case "todo":
            TaskManager.addTodo(taskName);
            break;
        case "deadline":
            TaskManager.addDeadline(taskName, deadline);
            break;
        case "event":
            TaskManager.addEvent(taskName, from, to);
            break;
        case "mark":
            TaskManager.markTask(taskIndex);
            break;
        case "unmark":
            TaskManager.unmarkTask(taskIndex);
            break;
        case "clear":
            TaskManager.clearTaskList();
            break;
        case "delete":
            TaskManager.deleteTask(taskIndex);
            break;
        default:
            System.out.println(Constants.SYNTAX_ERROR_MESSAGE);
        }
        System.out.println(Constants.LINE_BREAK);
    }
}

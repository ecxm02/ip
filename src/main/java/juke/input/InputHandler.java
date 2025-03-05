package juke.input;

import juke.task.TaskManager;
import juke.main.Juke;
import juke.main.Constants;

import java.time.LocalDate;

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
                                     LocalDate deadline, LocalDate from, LocalDate to) {

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
        case "help":
            System.out.println(Constants.HELP_MESSAGE);
            break;
        default:
            System.out.println("Invalid Command, type 'help' for a list of commands");
        }
        System.out.println(Constants.LINE_BREAK);
    }
}

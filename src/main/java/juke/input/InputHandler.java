package juke.input;

import juke.task.TaskManager;
import juke.main.Juke;
import juke.main.Constants;

public class InputHandler {
    private static String textInput;

    private InputHandler() {
    }

    public static void readText(TaskManager taskManager, String textInput) {
        Parser.cleanText(textInput);
        respondToText(taskManager, Parser.getInputCommand(), Parser.getTaskName(), Parser.getTaskIndex(),
                Parser.getDeadline(), Parser.getFrom(), Parser.getTo());
    }

    //uses a switch to execute appropriate methods for the input
    public static void respondToText(TaskManager taskManager, String inputCommand, String taskName, int taskIndex,
                                     String deadline, String from, String to) {

        switch (inputCommand) {
        case "bye":
            Juke.endProgram();
            break;
        case "list":
            taskManager.listTask();
            break;
        case "todo":
            taskManager.addTodo(taskName);
            break;
        case "deadline":
            taskManager.addDeadline(taskName, deadline);
            break;
        case "event":
            taskManager.addEvent(taskName, from, to);
            break;
        case "mark":
            taskManager.markTask(taskIndex);
            break;
        case "unmark":
            taskManager.unmarkTask(taskIndex);
            break;
        case "clear":
            taskManager.clearTaskList();
            break;
        case "delete":
            taskManager.deleteTask(taskIndex);
            break;
        }
        System.out.println(Constants.LINE_BREAK);
    }
}

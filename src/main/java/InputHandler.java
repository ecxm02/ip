public class InputHandler {
    private static String textInput;

    private InputHandler() {
    }

    public static void readText(TaskManager taskList, String textInput) {
        Parser.cleanText(textInput);
        respondToText(taskList, Parser.getInputCommand(), Parser.getTaskName(), Parser.getTaskIndex(),
                Parser.getDeadline(), Parser.getFrom(), Parser.getTo());
    }

    //uses a switch to execute appropriate methods for the input
    public static void respondToText(TaskManager taskList, String inputCommand, String taskName, int taskIndex,
                                     String deadline, String from, String to) {
        System.out.println(Constants.LINE_BREAK);

        switch (inputCommand) {
        case "bye":
            Juke.endProgram();
            break;
        case "list":
            taskList.listTask();
            break;
        case "todo":
            taskList.addTodo(taskName);
            break;
        case "deadline":
            taskList.addDeadline(taskName, deadline);
            break;
        case "event":
            taskList.addEvent(taskName, from, to);
            break;
        case "mark":
            taskList.markTask(taskIndex);
            break;
        case "unmark":
            taskList.unmarkTask(taskIndex);
            break;
        }

        System.out.println(Constants.LINE_BREAK);
    }
}

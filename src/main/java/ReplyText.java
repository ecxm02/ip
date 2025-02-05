public class ReplyText {
    private static TaskManager taskList = new TaskManager();
    private String textInput;


    public ReplyText(String textInput) {
        this.textInput = textInput;
        ParseText cleaner = new ParseText(textInput);
        respondToText(cleaner.getInputCommand(), cleaner.getTaskName(), cleaner.getTaskIndex(),
                cleaner.getDeadline(), cleaner.getFrom(), cleaner.getTo());
    }

    //uses a switch and if else statements to execute appropriate methods for the input
    public void respondToText(String inputCommand, String taskName, int taskIndex,
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
        default:
            System.out.println("Invalid command, Use: [todo], [deadline], [event], [list], [mark], [unmark] ");
        }

        System.out.println(Constants.LINE_BREAK);
    }
}

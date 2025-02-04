public class ReplyText {
    private static TaskManager taskList = new TaskManager();
    private String textInput;


    public ReplyText(String textInput) {
        this.textInput = textInput;
        ParseText cleaner = new ParseText(textInput);
        respondToText(cleaner.getParsedText(), cleaner.getTaskIndex());
    }

    //uses a switch and if else statements to execute appropriate methods for the input
    public void respondToText(String parsedText, int taskIndex) {
        System.out.println(Constants.LINE_BREAK);

        switch (parsedText) {
        case "bye":
            Juke.endProgram();
            break;
        case "list":
            taskList.listTask();
            break;
        default:
            if (parsedText.equals("mark")) {
                taskList.markTask(taskIndex);
            } else if (parsedText.equals("unmark")) {
                taskList.unmarkTask(taskIndex);
            } else {
                taskList.addTask(parsedText);
            }
        }

        System.out.println(Constants.LINE_BREAK);
    }
}

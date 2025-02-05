public class ParseText {
    private String textInput;
    private String inputCommand;
    private String taskName;
    private int taskIndex = -1;
    private String deadline;
    private String from;
    private String to;

    public ParseText(String textInput) {
        this.textInput = textInput;
        textCleanup();
    }

    private void textCleanup() {
        if (textInput.startsWith("mark") || textInput.startsWith("unmark")) {
            String[] words = textInput.split(" ");
            String taskNumber = words[1];
            taskIndex = Integer.parseInt(taskNumber) - 1;
            inputCommand = words[0];
        }

        else if (textInput.startsWith("deadline")) {
            int spaceIndex = textInput.indexOf(" ");
            inputCommand = textInput.substring(0, spaceIndex);
            int slashIndex = textInput.indexOf("/", spaceIndex + 1);
            taskName = textInput.substring(spaceIndex + 1, slashIndex - 1);
            deadline = textInput.substring(slashIndex + 4);
        }

        else if (textInput.startsWith("event")) {
            int spaceIndex = textInput.indexOf(" ");
            inputCommand = textInput.substring(0, spaceIndex);
            int slashIndex = textInput.indexOf("/", spaceIndex + 1);
            taskName = textInput.substring(spaceIndex + 1, slashIndex - 1);
            int slashIndex2 = textInput.indexOf("/", slashIndex + 1);
            from = textInput.substring(slashIndex + 6, slashIndex2 - 1);
            to = textInput.substring(slashIndex2 + 4);
        }

        else if (textInput.startsWith("todo")) {
            int spaceIndex = textInput.indexOf(" ");
            inputCommand = textInput.substring(0, spaceIndex);
            taskName = textInput.substring(spaceIndex + 1);
        }

        else {
            inputCommand = textInput;
        }
    }

    public String getInputCommand() {
        return inputCommand;
    }

    public int getTaskIndex() {
        return taskIndex;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getDeadline() {
        return deadline;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }
}

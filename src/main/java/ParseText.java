public class ParseText {
    private String textInput;
    private String inputCommand;
    private String taskName;
    private int taskIndex = -1;
    private int spaceIndex = -1;
    private int slashIndex = -1;
    private String deadline;
    private String from;
    private String to;

    public ParseText(String textInput) {
        this.textInput = textInput;
        spaceIndex = textInput.indexOf(" ");
        slashIndex = textInput.indexOf("/", spaceIndex + Constants.EMPTY_PAD);
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
            inputCommand = textInput.substring(0, spaceIndex);
            taskName = textInput.substring(spaceIndex + Constants.EMPTY_PAD, slashIndex - Constants.EMPTY_PAD);
            deadline = textInput.substring(slashIndex + Constants.BY_PAD);
        }

        else if (textInput.startsWith("event")) {
            inputCommand = textInput.substring(0, spaceIndex);
            taskName = textInput.substring(spaceIndex + Constants.EMPTY_PAD, slashIndex - Constants.EMPTY_PAD);
            int slashIndex2 = textInput.indexOf("/", slashIndex + Constants.EMPTY_PAD);
            from = textInput.substring(slashIndex + Constants.FROM_PAD, slashIndex2 - Constants.EMPTY_PAD);
            to = textInput.substring(slashIndex2 + Constants.TO_PAD);
        }

        else if (textInput.startsWith("todo")) {
            inputCommand = textInput.substring(0, spaceIndex);
            taskName = textInput.substring(spaceIndex + Constants.EMPTY_PAD);
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

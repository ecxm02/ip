public class Parser {
    private static String textInput;
    private static String inputCommand;
    private static String taskName;
    private static int taskIndex = -1;
    private static int spaceIndex = -1;
    private static int slashIndex = -1;
    private static String deadline;
    private static String from;
    private static String to;

    private Parser() {
    }

    public static void cleanText(String text) {
        textInput = text;
        spaceIndex = textInput.indexOf(" ");
        slashIndex = textInput.indexOf("/", spaceIndex + Constants.EMPTY_PAD);
        textCleanup();
    }

    private static void textCleanup() {
        if (textInput.startsWith("mark") || textInput.startsWith("unmark")) {
            cleanUpMark();
        } else if (textInput.startsWith("deadline")) {
            cleanUpDeadline();
        } else if (textInput.startsWith("event")) {
            cleanUpEvent();
        } else if (textInput.startsWith("todo")) {
            cleanUpTodo();
        } else {
            inputCommand = textInput;
        }
    }

    private static void cleanUpTodo() {
        inputCommand = textInput.substring(0, spaceIndex);
        taskName = textInput.substring(spaceIndex + Constants.EMPTY_PAD);
    }

    private static void cleanUpEvent() {
        inputCommand = textInput.substring(0, spaceIndex);
        taskName = textInput.substring(spaceIndex + Constants.EMPTY_PAD, slashIndex - Constants.EMPTY_PAD);
        int slashIndex2 = textInput.indexOf("/", slashIndex + Constants.EMPTY_PAD);
        from = textInput.substring(slashIndex + Constants.FROM_PAD, slashIndex2 - Constants.EMPTY_PAD);
        to = textInput.substring(slashIndex2 + Constants.TO_PAD);
    }

    private static void cleanUpDeadline() {
        inputCommand = textInput.substring(0, spaceIndex);
        taskName = textInput.substring(spaceIndex + Constants.EMPTY_PAD, slashIndex - Constants.EMPTY_PAD);
        deadline = textInput.substring(slashIndex + Constants.BY_PAD);
    }

    private static void cleanUpMark() {
        String[] words = textInput.split(" ");
        String taskNumber = words[1];
        taskIndex = Integer.parseInt(taskNumber) - 1;
        inputCommand = words[0];
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

    public static String getDeadline() {
        return deadline;
    }

    public static String getFrom() {
        return from;
    }

    public static String getTo() {
        return to;
    }
}

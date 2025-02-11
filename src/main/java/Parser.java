public class Parser {
    private static String textInput;
    private static String inputCommand = "invalid";
    private static String taskName;
    private static int taskIndex = -1;
    private static int spaceIndex = -1;
    private static int slashIndex = -1;
    private static int slashIndex2 = -1;
    private static String deadline;
    private static String from;
    private static String to;

    private Parser() {
    }

    public static void cleanText(String text) {
        resetVariables();
        textInput = text;

        spaceIndex = textInput.indexOf(" ");
        slashIndex = textInput.indexOf("/", spaceIndex + Constants.EMPTY_PAD);
        slashIndex2 = textInput.indexOf("/", slashIndex + Constants.EMPTY_PAD);

        if (textInput.startsWith("mark") || textInput.startsWith("unmark")) {
            cleanUpMark();
        } else if (textInput.startsWith("todo")) {
            cleanUpTodo();
        } else if (textInput.startsWith("deadline")) {
            cleanUpDeadline();
        } else if (textInput.startsWith("event")) {
            cleanUpEvent();
        } else {
            System.out.println("Invalid command, Use: [todo], [deadline], [event], [list], [mark], [unmark] ");
        }
    }

    private static void cleanUpMark() {
        String[] words = textInput.split(" ");
        String taskNumber = words[1];
        taskIndex = Integer.parseInt(taskNumber) - 1;
        inputCommand = words[0];
    }

    private static void cleanUpTodo() {
        if (spaceIndex == -1) {
            System.out.println("Invalid Command. Use todo + taskname");
            return;
        }
        inputCommand = textInput.substring(0, spaceIndex);
        taskName = textInput.substring(spaceIndex + Constants.EMPTY_PAD);
    }

    private static void cleanUpDeadline() {
        if (spaceIndex == -1 || slashIndex == -1) {
            System.out.println("Invalid Command. Use deadline + taskname + /by");
            return;
        }
        inputCommand = textInput.substring(0, spaceIndex);
        taskName = textInput.substring(spaceIndex + Constants.EMPTY_PAD, slashIndex - Constants.EMPTY_PAD);
        deadline = textInput.substring(slashIndex + Constants.BY_PAD);
    }

    private static void cleanUpEvent() {
        if (spaceIndex == -1 || slashIndex == -1 || slashIndex2 == -1) {
            System.out.println("Invalid Command. Use event + taskname + /from time /to time");
            return;
        }
        inputCommand = textInput.substring(0, spaceIndex);
        taskName = textInput.substring(spaceIndex + Constants.EMPTY_PAD, slashIndex - Constants.EMPTY_PAD);
        from = textInput.substring(slashIndex + Constants.FROM_PAD, slashIndex2 - Constants.EMPTY_PAD);
        to = textInput.substring(slashIndex2 + Constants.TO_PAD);
    }

    private static void resetVariables() {
        inputCommand = "invalid";
        taskName = null;
        taskIndex = -1;
        spaceIndex = -1;
        slashIndex = -1;
        slashIndex2 = -1;
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

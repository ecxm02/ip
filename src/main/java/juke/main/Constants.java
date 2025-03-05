package juke.main;

public class Constants {
    private Constants() {
    }

    public static final String LINE_BREAK = "---------------------------------------------------";
    public static final String SAVE_FILE_PATH = "save";
    public static final String SAVE_FILE_NAME = "save/jukeSaveFile.txt";
    public static final int EMPTY_PAD = 1;
    public static final int BY_PAD = 4;
    public static final int FROM_PAD = 6;
    public static final int TO_PAD = 4;
    public static final String END_MESSAGE = "Bye! See you again!" + System.lineSeparator();
    public static final String INTRO_MESSAGE = "Hello! I'm Juke" + System.lineSeparator()
            + "Excited to talk to you! :)" + System.lineSeparator()
            + LINE_BREAK;

    public static final String SYNTAX_ERROR_MESSAGE = "Command syntax error. Please check that your commands are formatted as follows:" + System.lineSeparator() +
            "1. To add a normal Task" + System.lineSeparator() +
            "'todo' + [Task Name]" + System.lineSeparator() + System.lineSeparator() +
            "2. To add a Deadline" + System.lineSeparator() +
            "'deadline' + [Task Name] + '/by' + [Deadline]" + System.lineSeparator() + System.lineSeparator() +
            "3. To add an Event" + System.lineSeparator() +
            "'event' + [Task Name] + '/from' + [Start] + '/to' + [End]" + System.lineSeparator() + System.lineSeparator() +
            "4. To mark any Task as Completed/Incomplete" + System.lineSeparator() +
            "'mark/unmark' + [Task Index]" + System.lineSeparator() + System.lineSeparator() +
            "5. To list all added Tasks" + System.lineSeparator() +
            "'list'" + System.lineSeparator() + System.lineSeparator() +
            "6. To delete a specific Task" + System.lineSeparator() +
            "'delete' + [Task Index]" + System.lineSeparator() + System.lineSeparator() +
            "7. To clear the whole Task List" + System.lineSeparator() +
            "'clear'";
}

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
            + "Excited to talk to you! :)" + System.lineSeparator() + System.lineSeparator();

    public static final String HELP_MESSAGE = "Here are the available commands!" + System.lineSeparator() +
            "** [Deadline], [Event] and [Task] need to be in standard form [YYYY-MM-DD] **" + System.lineSeparator() + System.lineSeparator() +
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
            "'clear'" + System.lineSeparator();

    public static final String DATE_PARSER_EXCEPTION = "Syntax Error detected! Ensure that your 'by', 'from', 'to' follows this date format"  + System.lineSeparator() +
            "[YEAR]-[MONTH]-[DATE], Example: 2025-01-31" + System.lineSeparator() +
            "Regardless of single digit months or days, pad with 0 if needed";

    public static final String TODO_PARSER_EXCEPTION = "Syntax Error detected! Ensure that your 'todo' command follows this format" + System.lineSeparator() +
            "'todo' + [Task Name]";

    public static final String DEADLINE_PARSER_EXCEPTION = "Syntax Error detected! Ensure that your 'deadline' command follows this format" + System.lineSeparator() +
            "'deadline' + [Task Name] + '/by' + [Deadline]";

    public static final String EVENT_PARSER_EXCEPTION = "Syntax Error detected! Ensure that your 'event' command follows this format" + System.lineSeparator() +
            "'event' + [Task Name] + '/from' + [Start] + '/to' + [End]";

    public static final String DELETE_PARSER_EXCEPTION = "Syntax Error detected! Ensure that your 'delete' command follows this format" + System.lineSeparator() +
            "'delete' + [Task Index]";

    public static final String MARK_PARSER_EXCEPTION = "Syntax Error detected! Ensure that your 'mark/unmark' command follows this format" + System.lineSeparator() +
            "'mark/unmark' + [Task Index]";
}

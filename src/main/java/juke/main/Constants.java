package juke.main;

/**
 * The `Constants` class holds all the constant values used throughout the application.
 * This includes messages, file paths, regular expressions, and error messages.
 */
public class Constants {
    private Constants() {
    }

    public static final String LINE_BREAK = "---------------------------------------------------";
    public static final String SAVE_FILE_PATH = "save";
    public static final String SAVE_FILE_NAME = "save/jukeSaveFile.txt";
    public static final String END_MESSAGE = "Bye! See you again!" + System.lineSeparator();
    public static final String INTRO_MESSAGE = "Hello! I'm Juke" + System.lineSeparator()
            + "Excited to talk to you! :)" + System.lineSeparator() + System.lineSeparator();

    /**
     * The help message displayed to the user, listing all available commands and their formats.
     */
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
            "7. To find a Task using a keyword" + System.lineSeparator() +
            "'find' + [Keyword]" + System.lineSeparator() + System.lineSeparator() +
            "8. To clear the whole Task List" + System.lineSeparator() +
            "'clear'" + System.lineSeparator();

    /**
     * The error message displayed when a date parsing error occurs.
     */
    public static final String DATE_PARSER_EXCEPTION = "Syntax Error detected! Ensure that your [by], [from], [to] follows this date format"  + System.lineSeparator() +
            "[YEAR]-[MONTH]-[DATE], Example: 2025-01-31" + System.lineSeparator() +
            "Regardless of single digit months or days, pad with 0 if needed";

    /**
     * The error message displayed when a 'todo' command parsing error occurs.
     */
    public static final String TODO_PARSER_EXCEPTION = "Syntax Error detected! Ensure that your 'todo' command follows this format" + System.lineSeparator() +
            "'todo' + [Task Name]";

    /**
     * The error message displayed when a 'deadline' command parsing error occurs.
     */
    public static final String DEADLINE_PARSER_EXCEPTION = "Syntax Error detected! Ensure that your 'deadline' command follows this format" + System.lineSeparator() +
            "'deadline' + [Task Name] + '/by' + [Deadline]";

    /**
     * The error message displayed when an 'event' command parsing error occurs.
     */
    public static final String EVENT_PARSER_EXCEPTION = "Syntax Error detected! Ensure that your 'event' command follows this format" + System.lineSeparator() +
            "'event' + [Task Name] + '/from' + [Start] + '/to' + [End]";

    /**
     * The error message displayed when a 'delete' command parsing error occurs.
     */
    public static final String DELETE_PARSER_EXCEPTION = "Syntax Error detected! Ensure that your 'delete' command follows this format" + System.lineSeparator() +
            "'delete' + [Task Index]";

    /**
     * The error message displayed when a 'mark' command parsing error occurs.
     */
    public static final String MARK_PARSER_EXCEPTION = "Syntax Error detected! Ensure that your 'mark' command follows this format" + System.lineSeparator() +
            "'mark' + [Task Index]";

    /**
     * The error message displayed when an 'unmark' command parsing error occurs.
     */
    public static final String UNMARK_PARSER_EXCEPTION = "Syntax Error detected! Ensure that your 'unmark' command follows this format" + System.lineSeparator() +
            "'unmark' + [Task Index]";

    /**
     * The error message displayed when a task index is out of bounds.
     */
    public static final String TASK_INDEX_OUT_OF_BOUNDS = "Index Error detected! Ensure that your Task Index is exists in your Task List" + System.lineSeparator() +
            "Type 'list' to view your Task List";

    /**
     * The error message displayed when a 'find' command parsing error occurs.
     */
    public static final String FIND_PARSER_EXCEPTION = "Syntax Error detected! Ensure that your 'find' command follows this format" + System.lineSeparator() +
            "'find' + [Keyword]";

    public static final String MARK_REGEX = "^mark\\s+(\\d+)$";
    public static final String UNMARK_REGEX = "^unmark\\s+(\\d+)$";
    public static final String TODO_REGEX = "^todo\\s+(.+)$";
    public static final String DEADLINE_REGEX = "^deadline\\s+(.+)\\s+/by\\s+(.+)$";
    public static final String EVENT_REGEX = "event\\s+(.+)\\s+/from\\s+(.+)\\s+/to\\s+(.+)$";
    public static final String DELETE_REGEX = "^delete\\s+(\\d+)$";
    public static final String FIND_REGEX = "^find\\s+(.+)$";

}

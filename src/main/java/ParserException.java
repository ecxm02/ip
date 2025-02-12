public class ParserException extends Exception {
    public ParserException() {
        super("Command syntax error. Please check that your commands are formatted as follows:" + System.lineSeparator() +
                "task + (Task Name) OR" + System.lineSeparator() +
                "deadline + (Task Name) + '/by' + (Deadline)  OR" + System.lineSeparator() +
                "event + (Task Name) + '/from' + (start) + 'to' + (end) OR" + System.lineSeparator() +
                "mark + (Task Index)" + System.lineSeparator());

        System.out.println(getMessage());
    }
}

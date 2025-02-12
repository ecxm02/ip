package juke.exception;

public class ParserException extends Exception {
    public ParserException() {
        super("Command syntax error. Please check that your commands are formatted as follows:" + System.lineSeparator() +
                "1. task + (Task Name)" + System.lineSeparator() +
                "2. deadline + (Task Name) + '/by' + (Deadline)" + System.lineSeparator() +
                "3. event + (Task Name) + '/from' + (Start) + '/to' + (End)" + System.lineSeparator() +
                "4. mark/unmark + (Task Index)" + System.lineSeparator());

        System.out.println(getMessage());
    }
}

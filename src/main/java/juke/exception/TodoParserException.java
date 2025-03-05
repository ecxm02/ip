package juke.exception;

import juke.main.Constants;

public class TodoParserException extends RuntimeException {
    public TodoParserException() {
        super(Constants.TODO_PARSER_EXCEPTION);
        System.out.println(getMessage());
    }
}

package juke.exception;

import juke.main.Constants;

public class EventParserException extends RuntimeException {
    public EventParserException() {
        super(Constants.EVENT_PARSER_EXCEPTION);
        System.out.println(getMessage());
    }
}

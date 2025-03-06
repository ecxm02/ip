package juke.exception;

import juke.main.Constants;

public class DeadlineParserException extends RuntimeException {
    public DeadlineParserException() {
        super(Constants.DEADLINE_PARSER_EXCEPTION);
    }
}

package juke.exception;

import juke.main.Constants;

public class DeleteParserException extends RuntimeException {
    public DeleteParserException() {
        super(Constants.DELETE_PARSER_EXCEPTION);
        System.out.println(getMessage());
    }
}

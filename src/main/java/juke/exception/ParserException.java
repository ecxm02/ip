package juke.exception;

import juke.main.Constants;

public class ParserException extends Exception {
    public ParserException() {
        super(Constants.SYNTAX_ERROR_MESSAGE);

        System.out.println(getMessage());
    }
}

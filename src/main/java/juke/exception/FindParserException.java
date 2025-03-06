package juke.exception;

import juke.main.Constants;

public class FindParserException extends RuntimeException {
    public FindParserException() {
        super(Constants.FIND_PARSER_EXCEPTION);
    }
}

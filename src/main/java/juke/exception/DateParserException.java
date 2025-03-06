package juke.exception;

import juke.main.Constants;

public class DateParserException extends RuntimeException {
    public DateParserException() {
        super(Constants.DATE_PARSER_EXCEPTION);
    }
}

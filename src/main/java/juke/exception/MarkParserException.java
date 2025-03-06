package juke.exception;

import juke.main.Constants;

public class MarkParserException extends RuntimeException {
    public MarkParserException(){
        super(Constants.MARK_PARSER_EXCEPTION);
    }
}
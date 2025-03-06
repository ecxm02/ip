package juke.exception;

import juke.main.Constants;

public class UnmarkParserException extends RuntimeException {
    public UnmarkParserException(){
        super(Constants.UNMARK_PARSER_EXCEPTION);
        System.out.println(getMessage());
    }
}
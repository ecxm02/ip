package juke.exception;

import juke.main.Constants;

public class TaskIndexOutOfBounds extends RuntimeException {
    public TaskIndexOutOfBounds() {
        super(Constants.TASK_INDEX_OUT_OF_BOUNDS);
    }
}

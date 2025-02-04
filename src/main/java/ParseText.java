public class ParseText {
    private String textInput;
    private String parsedText;
    private int taskIndex = 0;

    public ParseText(String textInput) {
        this.textInput = textInput;
        textCleanup();
    }

    private void textCleanup() {
        int spaceIndex = -1;
        if (textInput.startsWith("mark") || textInput.startsWith("unmark")) {
            spaceIndex = textInput.indexOf(" ");
            String taskNumber = textInput.substring(spaceIndex + 1);
            taskIndex = Integer.parseInt(taskNumber) - 1;
            parsedText = textInput.substring(0, spaceIndex);
        } else {
            parsedText = textInput;
        }
    }

    public String getParsedText() {
        return parsedText;
    }

    public int getTaskIndex() {
        return taskIndex;
    }
}

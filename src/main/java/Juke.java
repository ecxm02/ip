import java.util.Scanner;

public class Juke {
    private static boolean isCompleted = false; //a master flag so that main knows when to end the program

    //sets the isCompleted flag to true so that the loop ends, also prints end message
    public static void endProgram() {
        isCompleted = true;
        System.out.println("Bye! See you again :)");
    }

    public static void main(String[] args) {
        System.out.println(Constants.INTRO_MESSAGE);
        Scanner input = new Scanner(System.in);
        String text;

        while (!isCompleted) {
            text = input.nextLine();
            ReplyText current = new ReplyText(text);
        }
        input.close();
    }
}
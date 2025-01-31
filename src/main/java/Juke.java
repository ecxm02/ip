import java.util.Scanner;

public class Juke {
    static boolean isDone = false;

    static void replyText(String text) {
        System.out.println("---------------------------------------------------");
        if (text.equals("bye")) {
            isDone = true;
            System.out.println("Bye! See you again :)");
        } else {
            System.out.println(text);
        }
        System.out.println("---------------------------------------------------");
    }

    public static void main(String[] args) {
        System.out.println("---------------------------------------------------");
        System.out.println("Hello! I'm Juke");
        System.out.println("SAY SOMETHING!");
        System.out.println("---------------------------------------------------");

        Scanner input = new Scanner(System.in);
        String text;

        while (!isDone) {
            text = input.nextLine();
            replyText(text);
        }

        input.close();
    }
}
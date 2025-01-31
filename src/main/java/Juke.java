import java.util.Scanner;

public class Juke {
    static boolean isDone = false;
    static String[] list = new String[100];
    static int currentListPosition = 0;

    static void endProgram() {
        isDone = true;
        System.out.println("Bye! See you again :)");
    }

    static void listTask() {
        for (int i = 0; i < list.length && list[i] != null; i++) {
            System.out.println((i + 1) + ". " + list[i]);
        }
    }

    static void addTask(String text) {
        list[currentListPosition] = text;
        currentListPosition++;
        System.out.println("added: " + text);
    }

    static void replyText(String text) {
        System.out.println("---------------------------------------------------");

        if (text.equals("bye")) {
            endProgram();
        } else if (text.equals("list")) {
            listTask();
        } else {
            addTask(text);
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
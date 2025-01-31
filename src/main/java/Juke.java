import java.util.Scanner;

public class Juke {
    static boolean isCompleted = false; //a master flag so that main knows when to end the program
    static Task[] list = new Task[100]; //array of Task
    static int currentListPosition = 0; //keep track of where to add new tasks

    static void endProgram() { //sets the isCompleted flag to true so that the loop ends, also prints end message
        isCompleted = true;
        System.out.println("Bye! See you again :)");
    }

    static void listTask() { //prints out the tasks and marks them appropriately
        for (int i = 0; i < currentListPosition; i++) {
            System.out.print((i + 1));

            if (list[i].isDone()) {
                System.out.println(".[X] " + list[i].getTask());
            } else {
                System.out.println(".[ ] " + list[i].getTask());
            }
        }
    }

    static void addTask(String text) { //adds tasks into the array
        list[currentListPosition] = new Task(text);
        list[currentListPosition].setTask(text);
        currentListPosition++;
        System.out.println("added: " + text);
    }

    static void markTask(String text) { //marks a task as completed
        int spaceIndex = text.indexOf(" ");
        String taskNumber = text.substring(spaceIndex + 1);
        int taskIndex = Integer.parseInt(taskNumber) - 1;
        list[taskIndex].markTask();
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("[X] " + list[taskIndex].getTask());
    }

    static void unmarkTask(String text) { //marks a task as uncompleted
        int spaceIndex = text.indexOf(" ");
        String taskNumber = text.substring(spaceIndex + 1);
        int taskIndex = Integer.parseInt(taskNumber) - 1;
        list[taskIndex].unmarkTask();
        System.out.println("Nice! I've marked this task as uncompleted:");
        System.out.println("[ ] " + list[taskIndex].getTask());
    }


    static void replyText(String text) { //uses a swtich and if else statments to execute appropriate methods for the input
        System.out.println("---------------------------------------------------");

        switch (text) {
        case "bye":
            endProgram();
            break;
        case "list":
            listTask();
            break;
        default:
            if (text.startsWith("mark")) {
                markTask(text);
            } else if (text.startsWith("unmark")) {
                unmarkTask(text);
            } else {
                addTask(text);
            }
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

        while (!isCompleted) {
            text = input.nextLine();
            replyText(text);
        }

        input.close();
    }
}
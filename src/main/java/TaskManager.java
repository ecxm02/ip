public class TaskManager {
    private Task[] taskList = new Task[Constants.LIST_SIZE];
    private int currentListPosition = 0; //keep track of where to add new tasks

    public TaskManager() {
    }

    public void listTask() { //prints out the tasks and marks them appropriately
        for (int i = 0; i < currentListPosition; i++) {
            System.out.print((i + 1));

            if (taskList[i].isDone()) {
                System.out.println(".[X] " + taskList[i].getTask());
            } else {
                System.out.println(".[ ] " + taskList[i].getTask());
            }
        }
    }

    public void addTask(String text) { //adds tasks into the array
        taskList[currentListPosition] = new Task(text);
        taskList[currentListPosition].setTask(text);
        currentListPosition += 1;
        System.out.println("added: " + text);
    }

    public void markTask(int taskIndex) { //marks a task as completed
        taskList[taskIndex].markTask();
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("[X] " + taskList[taskIndex].getTask());
    }

    public void unmarkTask(int taskIndex) { //marks a task as uncompleted
        taskList[taskIndex].unmarkTask();
        System.out.println("Nice! I've marked this task as uncompleted:");
        System.out.println("[ ] " + taskList[taskIndex].getTask());
    }
}

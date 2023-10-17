import java.util.ArrayList;
import java.util.Scanner;
public class ToDoListApp {
    private ArrayList<String> todoList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        ToDoListApp todoListApp = new ToDoListApp();
        todoListApp.runTodoList();
}
public void runTodoList() {
        int choice;
        do {
        displayMenu();
        System.out.print("Enter your choice: ");
        choice = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        switch (choice) {
        case 1:
        displayList();
        break;
        case 2:
        System.out.print("Enter the task to add: ");
        String taskToAdd = scanner.nextLine();
        addTask(taskToAdd);
        break;
        case 3:
        System.out.print("Enter the task index to remove: ");
        int taskIndexToRemove = scanner.nextInt();
        removeTask(taskIndexToRemove);
        break;
        case 4:
        System.out.println("Exiting Todo List. Goodbye!");
        break;
        default:
        System.out.println("Invalid choice. Please try again.");
        }
        } while (choice != 4);
        }

        public void displayMenu() {
        System.out.println("\nTodo List Menu:");
        System.out.println("1. Display To-Do List");
        System.out.println("2. Add Task");
        System.out.println("3. Remove Task");
        System.out.println("4. Quit");
        }

        public void displayList() {
        System.out.println("\nTo-Do List:");
        for (int i = 0; i < todoList.size(); i++) {
        System.out.println(i + ". " + todoList.get(i));
        }
        }

        public void addTask(String task) {
        todoList.add(task);
        System.out.println("Task added: " + task);
        }

        public void removeTask(int taskIndex) {
        if (taskIndex >= 0 && taskIndex < todoList.size()) {
        String removedTask = todoList.remove(taskIndex);
        System.out.println("Task removed: " + removedTask);
        } else {
        System.out.println("Invalid task index. No task removed.");
        }
        }
        }

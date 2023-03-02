/*
 * For this assignment, you will create an interactive To-Do (Task list) application using a PriorityQueue
 * data structure. To-Do items or tasks have a priority associated with them and this priority will be the
 * sort criteria for your PriorityQueue. The interactive test driver loop should:
 * 1. add a task by capturing the subject, priority, and due date.
 * 2. view the next task in the queue by using the peek() and poll() method
 * 3. view all the tasks using an iterator.
 * 4. remove a task by id.
 *
 * R Stone
 */

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.PriorityQueue;
import java.util.Scanner;

enum Priority {URGENT, HIGH, NORMAL, LOW}

enum Status {NOT_STARTED, IN_PROGRESS, WAITING, DEFERRED}

class Task implements Comparable<Task> {
    int taskId;
    String subject;
    Priority priority;
    Status status;
    LocalDate startDate;
    LocalDate dueDate;

    public Task(int taskId, String subject, Priority priority, Status status, LocalDate startDate, LocalDate dueDate) {
        this.taskId = taskId;
        this.subject = subject;
        this.priority = priority;
        this.status = status;
        this.startDate = startDate;
        this.dueDate = dueDate;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public int compareTo(Task task) {
        return this.getPriority().compareTo(task.getPriority());
    }

    @Override
    public String toString() {
        return "Id:" + taskId + "; Subject: " + subject + "; Priority: " + priority + "; Status: " + status + "; Started: " + startDate + "; Due: " + dueDate + "\n";
    }
}

public class taskList {
    PriorityQueue<Task> taskPriorityQueue = new PriorityQueue<>();

    Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        taskList app = new taskList();
        app.printStuff();
    }

    public void viewAllTasks() {
        if (!taskPriorityQueue.isEmpty()) {
            for (Task task : taskPriorityQueue) {
                System.out.print(task);
            }
        } else {
            System.out.println("Nothing to see here...\n");
        }
    }

    public void displayTask() {
        if (taskPriorityQueue.isEmpty()) {
            System.out.println("You don't have any tasks to view! Consider adding tasks before viewing an empty list.\n");
        } else {
            System.out.print("What specific task # would you like to view? ");

            int getTask = Integer.parseInt(in.nextLine());

            System.out.print(getTaskById(getTask));
        }
    }

    public void viewNext() {
        if (taskPriorityQueue.isEmpty()) {
            System.out.print("You don't have any upcoming tasks!");
        } else {
            System.out.print(taskPriorityQueue.peek());
            System.out.print("Would you like to mark this as complete? (y/n) ");

            String isComplete = in.nextLine().toLowerCase();

            boolean tryComplete = true;

            do {
                try {
                    if (isComplete.equals("y")) {
                        taskPriorityQueue.poll();
                        System.out.println("Task marked as complete.");
                        tryComplete = false;
                    } else if (isComplete.equals("n")) {
                        System.out.println("Task not removed.");
                        tryComplete = false;
                    }
                } catch (Exception e) {
                    System.out.println("There was an error processing your request. Try again.");
                }
            } while (tryComplete);

        }
    }

    public Task getTaskById(int taskId) {
        for (Task task : taskPriorityQueue) {
            if (task.getTaskId() == taskId) {
                return task;
            }
        }
        System.out.println("Task not found...\n");
        return null;
    }

    public void addTask() {
        boolean tryAdd = true;
        System.out.println("\nAdding new task...");
        System.out.print("Enter subject: ");
        String subject = in.nextLine();
        do {

            try {
                System.out.print("Enter due date (yyyy-MM-dd): ");
                String getDate = in.nextLine();
                LocalDate dueDate = LocalDate.parse(getDate);

                Task task = new Task(taskPriorityQueue.size() + 1, subject, checkPriority(), Status.NOT_STARTED, LocalDate.now(), dueDate);

                taskPriorityQueue.add(task);

                System.out.println("New task added.");

                System.out.println(task);

                tryAdd = false;
            } catch (DateTimeParseException e) {
                System.out.println("Date format error. Try again.");
            }
        } while (tryAdd);
    }

    public void removeTask() {
        if (taskPriorityQueue.isEmpty()) {
            System.out.println("You don't have any tasks to remove! Consider adding a task before removing nothing.\n");
        } else {
            System.out.println("Which task would you like to remove?");
            viewAllTasks();
            int getTask = Integer.parseInt(in.nextLine());

            try {
                taskPriorityQueue.remove(getTaskById(getTask));
                System.out.println("Task removed.");

                for (Task task : taskPriorityQueue) {
                    if (task.getTaskId() != 1) {
                        task.setTaskId(task.getTaskId() - 1);
                    } else {
                        break;
                    }
                }

            } catch (Exception e) {
                System.out.println("Something went wrong...\n");
            }
        }
    }

    public void editTask() {
        if (taskPriorityQueue.isEmpty()) {
            System.out.println("You don't have any tasks to edit! Consider adding a task before trying to edit nothing.\n");
        } else {
            viewAllTasks();
            System.out.println("What task would you like to edit?");

            int taskGetter = Integer.parseInt(in.nextLine());

            System.out.println("""
                    What would you like to edit?
                    Subject (s)
                    Priority level (p)
                    Status (st)
                    Due date (d)""");

            Task currentEdit = getTaskById(taskGetter);

            String editTask = in.nextLine().toLowerCase();

            switch (editTask) {
                case "s" -> {
                    System.out.print("Edit subject line: ");
                    String editSubject = in.nextLine().toLowerCase();
                    currentEdit.setSubject(editSubject);
                    System.out.println("Changed subject.");
                    System.out.println(currentEdit);
                }
                case "p" -> {
                    currentEdit.setPriority(checkPriority());
                    System.out.println("Changed priority.");
                    System.out.println(currentEdit);
                }
                case "st" -> {
                    currentEdit.setStatus(changeStatus());
                    System.out.println("Changed status.");
                    System.out.println(currentEdit);
                }
                case "d" -> {
                    boolean tryEdit = true;
                    do {
                        try {
                            System.out.print("Enter new due date (yyyy-MM-dd): ");
                            String dateDate = in.nextLine();
                            LocalDate editDate = LocalDate.parse(dateDate);

                            currentEdit.setDueDate(editDate);

                            System.out.println("Due date successfully changed.");
                            System.out.println(currentEdit);

                            tryEdit = false;
                        } catch (DateTimeParseException e) {
                            System.out.println("Date format error. Try again.");
                        }
                    } while (tryEdit);
                }
            }
        }
    }

    private Priority checkPriority() {
        Priority priority = Priority.NORMAL;
        System.out.println("""
                Enter a priority level:
                Normal (n)
                Low (l)
                High (h)
                Urgent (u)""");
        String getPriority = in.nextLine().toLowerCase();
        switch (getPriority) {
            case "n":
                break;
            case "l":
                priority = Priority.LOW;
                break;
            case "h":
                priority = Priority.HIGH;
                break;
            case "u":
                priority = Priority.URGENT;
        }
        return priority;
    }

    private Status changeStatus() {
        Status status = Status.NOT_STARTED;
        System.out.print("""
                \nEnter a status level:
                Not started (n)
                In progress (p)
                Deferred (d)
                Waiting (w)""");
        String getStatus = in.nextLine().toLowerCase();
        switch (getStatus) {
            case "n":
                break;
            case "p":
                status = Status.IN_PROGRESS;
                break;
            case "d":
                status = Status.DEFERRED;
                break;
            case "w":
                status = Status.WAITING;
                break;
        }
        return status;
    }

    public void printStuff() {
        System.out.println("Welcome to the Task List!");
        do {
            System.out.println("""
                    \nChoose an action:
                    Add task (a)
                    Remove task (r)
                    Edit task (e)
                    Display specific task (d)
                    Display next task (n)
                    View all tasks (v)
                    Quit (q)""");

            String menuItem = in.nextLine().toLowerCase();

            switch (menuItem) {
                case "a" -> addTask();
                case "r" -> removeTask();
                case "e" -> editTask();
                case "d" -> displayTask();
                case "n" -> viewNext();
                case "v" -> viewAllTasks();

                case "q" -> {
                    System.out.println("Goodbye");
                    in.close();
                    System.exit(0);
                }
                default -> System.out.println("Command not found.\n");
            }
        } while (true);
    }
}
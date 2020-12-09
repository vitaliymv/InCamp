package week1.day2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;


public class Structures {

    public static class Task {
        private int id;
        private boolean done;
        private String title;
        private String description;
        private LocalDate dueDate;

        public Task() {
        }

        public Task(int id, boolean done, String title, String description, LocalDate dueDate) {
            this.id = id;
            this.done = done;
            this.title = title;
            this.description = description;
            this.dueDate = dueDate;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public boolean isDone() {
            return done;
        }

        public void setDone(boolean done) {
            this.done = done;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public LocalDate getDueDate() {
            return dueDate;
        }

        public void setDueDate(LocalDate dueDate) {
            this.dueDate = dueDate;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "id=" + id +
                    ", done=" + done +
                    ", title='" + title + '\'' +
                    ", description='" + description + '\'' +
                    ", dueDate=" + dueDate +
                    '}';
        }

    }


    //1. [x] Implement task output (Aug 25)
    //   Use fields: title, desc, done, dueDate

    public static void main(String[] args) {
        System.out.println(getString(getTask1()));
        System.out.println(getString(getTask2()));

    }

    private static Task getTask2() {
        Task task = new Task();
        task.setId(2);
        task.setDone(true);
        task.setTitle("Implement task output");
        task.setDueDate(LocalDate.of(2021, 6, 25));
        task.setDescription("Use fields: title, desc, done, dueDate");
        return task;
    }

    private static Task getTask1() {
        return new Task(1,
                    false,
                    "Completed studying in university",
                    "Get a master's degree in cybersecurity",
                    LocalDate.of(2021, 7, 3));
    }

    public static String getString(Task task) {
        return String.format("%d. [%c] %s (%s %d) \n %s",
                task.getId(),
                toChar(task),
                task.getTitle(),
                task.getDueDate().getMonth(),
                task.getDueDate().getDayOfMonth(),
                task.getDescription());
    }

    public static char toChar(Task task) {
        if(task.isDone()) {
            return 'x';
        }
        return ' ';
    }
}
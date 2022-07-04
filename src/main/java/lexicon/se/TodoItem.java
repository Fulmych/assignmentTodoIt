package lexicon.se;

import java.text.ParseException;
import java.time.LocalDate;

public class TodoItem {
    private int id;
    String title = "None";
    String taskDescription = "None";
    LocalDate deadLine;
    boolean done;
    Person creator;
    LocalDate now = LocalDate.now();
    int getId(){
        return this.id;
    }
    String getTitle(){
        return title;
    }
    void setTitle(String title){
        this.title = title;
        id++;
    }
    String getTaskDescription(){
        return taskDescription;
    }
    void setTaskDescription(String taskDescription){
        this.taskDescription = taskDescription;
    }
    LocalDate getDeadLine(){
        return deadLine;
    }
    void setDeadLine(LocalDate deadLine){
        this.deadLine = deadLine;
    }
    void setDone(boolean done){
        this.done = done;
    }
    boolean isDone(){
        return done;
    }
    Person getCreator(){
        return creator;
    }
    void setCreator(Person creator){
        this.creator = creator;
    }
    boolean isOverdue() {
     //   LocalDate deadLine = LocalDate.parse("2022-12-24"); //For Testing
        return !deadLine.isBefore(now);
    }
    String getSummary() {
        String n = "";
        System.out.println("Id: " + id + "\n" + "Title: " + title + "\n" + "Description: " + taskDescription + "\n" + "Creator: " + creator.getFirstName() + " " + creator.getLastName() + "\n" + "Done: " + done + "\n" + "Is overdue: " + isOverdue());
        return n;
    }
}

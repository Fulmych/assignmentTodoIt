package lexicon.se;

import java.text.ParseException;
import java.time.LocalDate;

public class TodoItemTask {
    public static void main(String[] args) throws ParseException {
        Person anders = new Person();
        anders.setFirstName("Anders");
        anders.setLastName("Beritsson");
        anders.setEmail("anders.beritsson@gmail.com");
        anders.getSummary();

        Person lars = new Person();
        lars.setFirstName("Lars");
        lars.setLastName("Parad");
        lars.setEmail("lars.parad@gmail.com");
        lars.getSummary();

        TodoItem carCleaning = new TodoItem();
        carCleaning.setTitle("Car Cleaning");
        carCleaning.setCreator(lars);
        carCleaning.setDone(false);
        carCleaning.setTaskDescription("Cleaning cars, nothing more.");
        carCleaning.setDeadLine(LocalDate.parse("2022-12-22"));
        carCleaning.getSummary();

    }
}

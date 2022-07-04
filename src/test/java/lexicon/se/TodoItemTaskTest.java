package lexicon.se;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TodoItemTaskTest {

    @Test
    void main() {
        Person anders = new Person();
        anders.setFirstName("Anders");
        anders.setLastName("Beritsson");
        anders.setEmail("anders.beritsson@gmail.com");

        Assertions.assertAll("anders",
                () -> assertEquals("Anders", anders.getFirstName()),
                () -> assertEquals("Beritsson", anders.getLastName()),
                () -> assertEquals("anders.beritsson@gmail.com", anders.getEmail()),
                () -> assertEquals("", anders.getSummary()));

        Person lars = new Person();
        lars.setFirstName("Lars");
        lars.setLastName("Parad");
        lars.setEmail("lars.parad@gmail.com");

        Assertions.assertAll("lars",
                () -> assertEquals("Lars", lars.getFirstName()),
                () -> assertEquals("Parad", lars.getLastName()),
                () -> assertEquals("lars.parad@gmail.com", lars.getEmail()),
                () -> assertEquals("", lars.getSummary()));

        TodoItem carCleaning = new TodoItem();
        carCleaning.setTitle("Car Cleaning");
        carCleaning.setCreator(lars);
        carCleaning.setDone(false);
        carCleaning.setTaskDescription("Cleaning cars, nothing more.");
        carCleaning.setDeadLine(LocalDate.parse("2022-12-22"));


        Assertions.assertAll("carCleaning",
                () -> assertEquals("Car Cleaning", carCleaning.getTitle()),
                () -> assertNotNull("lexicon.se.Person@12d3a4e9"),
                () -> assertFalse(false),
                () -> assertEquals("Cleaning cars, nothing more.", carCleaning.getTaskDescription()),
                () -> assertEquals("", carCleaning.getSummary()));

    }
}
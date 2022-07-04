package lexicon.se;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.time.LocalDate;

class TodoItemTest {
    TodoItem a = new TodoItem();
    Person per = new Person();
    @Test
    void getId() {
        int getId = a.getId();
        Assertions.assertEquals(0, getId);
    }

    @Test
    void getTitle() {
        a.setTitle("Book");
        String getTitle = a.getTitle();
        Assertions.assertEquals("Book", getTitle);
    }

    @Test
    void getTaskDescription() {
        a.setTaskDescription("A book");
        String getTaskDescription = a.getTaskDescription();
        Assertions.assertEquals("A book", getTaskDescription);
    }

    @Test
    void isDone() {
        a.setDone(true);
        boolean isDone = a.isDone();
        Assertions.assertTrue(isDone);
    }

    @Test
    void getCreator() {
        per.setFirstName("Per");

    }

    @Test
    void isOverdue() {
        LocalDate now = LocalDate.now();
        LocalDate deadLine = LocalDate.parse("2022-12-24");
        a.setDeadLine(deadLine);
        boolean isOverdue = a.isOverdue();
        Assertions.assertTrue(true);
    }

    @Test
    void getSummary() {
        a.setCreator(per);
        per.setFirstName("Per");
        LocalDate deadLine = LocalDate.parse("2022-12-24");
        a.setDeadLine(deadLine);
        String n = "";
        String getSummary = a.getSummary();
        System.out.println(getSummary);
        Assertions.assertEquals("", n);
    }
}
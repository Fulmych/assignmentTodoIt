package lexicon.se;

import lexicon.se.model.AppRole;
import lexicon.se.model.AppUser;
import lexicon.se.model.Person;
import lexicon.se.model.TodoItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

class TodoItemTest {
    AppUser b = new AppUser();
    Person lars = new Person("Lars", "Persson", "lars.persson@mail.com", "Lasse", "Highrock", AppRole.ROLE_APP_ADMIN);
    TodoItem a = new TodoItem("Book", "A book", LocalDate.parse("2022-12-24"), true, lars, LocalDate.now());
    @Test
    void getId() {
        int getId = a.getId();
        Assertions.assertEquals(0, getId);
    }

    @Test
    void getTitle() {
        String getTitle = a.getTitle();
        Assertions.assertEquals("Book", getTitle);
    }

    @Test
    void getTaskDescription() {
        String getTaskDescription = a.getTaskDescription();
        Assertions.assertEquals("A book", getTaskDescription);
    }

    @Test
    void isDone() {
        boolean isDone = a.isDone();
        Assertions.assertTrue(isDone);
    }

    @Test
    void getCreator() {
        Person getCreator = lars;
        Assertions.assertEquals("lars", getCreator);

    }

    @Test
    void isOverdue() {
        boolean isOverdue = a.isOverdue();
        Assertions.assertTrue(isOverdue);
    }
    @Test
    void testToString() {
        String toString = a.toString();
        Assertions.assertEquals("TodoItem{" +
                "id=" + 1 +
                ", title='" + "Book" + '\'' +
                ", taskDescription='" + "A book" + '\'' +
                ", deadLine=" + "2022-12-24" +
                ", done=" + "true" +
                ", now=" + "2022-07-04" +
                '}', toString);
    }
}
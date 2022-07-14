package lexicon.se;

import lexicon.se.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class TodoItemTaskTest {
    AppUser b = new AppUser();
    Person lars = new Person("Lars", "Parad", "lars.Parad@mail.com", "Lasse", "Highrock", AppRole.ROLE_APP_ADMIN);
    TodoItem car = new TodoItem("Car Washing", "Washing the car.", LocalDate.parse("2022-12-24"), false, lars, LocalDate.now());
    TodoItemTask a = new TodoItemTask(true, car, lars);
    @Test
    void getId() {
        int getId = a.getId();
        Assertions.assertEquals(4, getId);
    }

    @Test
    void isAssigned() {
        boolean isAssigned = a.isAssigned();
        Assertions.assertTrue(isAssigned);
    }

    @Test
    void getToDoItem() {
        TodoItem getToDoItem = a.getToDoItem();
        Assertions.assertEquals(car, getToDoItem);
    }
    @Test
    void getAssigne() {
        Person getAssigne = a.getAssigne();
        Assertions.assertEquals(lars, getAssigne);
    }

    @Test
    void testToString() {
        String toString = a.toString();
        Assertions.assertEquals("TodoItemTask[" +
                "id=" + 2 +
                ", assigned=" + true +
                ", toDoItem='" + car + '\'' +
                ']', toString);
    }
}
package lexicon.se;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
class TodoItemTaskTest {
    Person lars = new Person("Lars", "Parad", "lars.Parad@mail.com", "Lasse", "Highrock", AppRole.ROLE_APP_ADMIN);
    TodoItemTask a = new TodoItemTask(true, "Clean Cars", lars);
    @Test
    void getId() {
        int getId = a.getId();
        Assertions.assertEquals(1, getId);
    }

    @Test
    void isAssigned() {
        boolean isAssigned = a.isAssigned();
        Assertions.assertTrue(isAssigned);
    }

    @Test
    void getToDoItem() {
        String getToDoItem = a.getToDoItem();
        Assertions.assertEquals("Clean Cars", getToDoItem);
    }
    @Test
    void getAssigne() {
        Person getAssigne = a.getAssigne();
        Assertions.assertEquals(lars, getAssigne);
    }

    @Test
    void testToString() {
        String toString = a.toString();
        Assertions.assertEquals("TodoItemTask{" +
                "id=" + 1 +
                ", assigned=" + lars +
                ", toDoItem='" + "Clean Cars" + '\'' +
                '}', toString);
    }
}
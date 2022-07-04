package lexicon.se;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PersonTest {
    Person a = new Person();
    @Test
    void getId() {
        int getId = a.getId();
        Assertions.assertEquals(0, getId);
    }
    @Test
    void getFirstName() {
        a.setFirstName("Lars");
        String getFirstName = a.getFirstName();
        Assertions.assertEquals("Lars", "Lars");
    }

    @Test
    void getLastName() {
        a.setLastName("Persson");
        String getLastName = a.getLastName();
        Assertions.assertEquals("Persson", "Persson");
    }

    @Test
    void getEmail() {
        a.setEmail("lars.persson@gmail.com");
        String getEmail = a.getEmail();
        Assertions.assertEquals("lars.persson@gmail.com", "lars.persson@gmail.com");
    }

    @Test
    void getSummary() {
        String n = "";
        String getSummary = a.getSummary();
        Assertions.assertEquals("", "");
    }
}
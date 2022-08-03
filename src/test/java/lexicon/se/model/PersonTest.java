package lexicon.se.model;
import lexicon.se.model.AppRole;
import lexicon.se.model.AppUser;
import lexicon.se.model.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PersonTest {
    AppUser b = new AppUser();
    Person a = new Person("Lars", "Persson", "lars.persson@mail.com", "Lasse", "Highrock", AppRole.ROLE_APP_ADMIN);

    @Test
    void getId() {
        int getId = a.getId();
        Assertions.assertEquals(0, getId);
    }
    @Test
    void getFirstName() {
        a.setFirstName("Lars");
        String getFirstName = a.getFirstName();
        Assertions.assertEquals("Lars", getFirstName);
    }

    @Test
    void getLastName() {
        a.setLastName("Persson");
        String getLastName = a.getLastName();
        Assertions.assertEquals("Persson", getLastName);
    }

    @Test
    void getEmail() {
        a.setEmail("lars.persson@gmail.com");
        String getEmail = a.getEmail();
        Assertions.assertEquals("lars.persson@gmail.com", getEmail);
    }
    @Test
    void getCredentials() {
        a.setCredentials(b);
        Assertions.assertEquals("AppUser{" +
                "username='" + "PerBoy" + '\'' +
                ", role=" + "User" +
                '}', a.getCredentials().toString());

    }
    @Test
    void testToString() {
        a.setFirstName("Lars");
        a.setLastName("Persson");
        a.setEmail("lars.persson@gmail.com");
        String toString = a.toString();
        Assertions.assertEquals("Person{" +
                    "id=" + 0 +
                    ", firstName='" + "Lars" + '\'' +
                    ", lastName='" + "Persson" + '\'' +
                    ", email='" + "lars.persson@gmail.com" + '\'' +
                    '}', toString);
    }
}
package lexicon.se.data_access;

import lexicon.se.model.AppRole;
import lexicon.se.model.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonDAOListTest {
    List<Person> people = new ArrayList<>();
    Person a = new Person("Lars", "Berg", "lars.berg@mail.com", "Lasse", "bergen", AppRole.ROLE_APP_ADMIN);

    @Test
    void persist() {
        people.add(a);
        Assertions.assertEquals(1, people.size());
    }

    @Test
    void findById() {
        people.add(a);
        Assertions.assertEquals(a, people.stream()
                .filter(person -> person.getId() == a.getId())
                .map(Person.class::cast)
                .findAny()
                .orElse(null));
    }

    @Test
    void findByEmail() {
        people.add(a);
        Assertions.assertEquals(a, people.stream()
                .filter(person -> person.getEmail().equals(a.getEmail()))
                .map(Person.class::cast)
                .findAny()
                .orElse(null));

    }

    @Test
    void findAll() {
        Assertions.assertEquals(people, people);
    }

    @Test
    void remove() {
        people.removeIf(person -> person.getId()==3);
        Assertions.assertEquals(0, people.size());
    }
}